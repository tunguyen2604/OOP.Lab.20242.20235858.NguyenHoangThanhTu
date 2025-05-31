package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Cart cart;
    private Store store;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private Button placeOrderBtn;

    private ObservableList<Media> mediaList;
    private FilteredList<Media> filteredMediaList;

    
    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        System.out.println(cart.getItemsOrdered());

        if(cart.getItemsOrdered() != null) {
            mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
            filteredMediaList = new FilteredList<>(mediaList, p -> true); 
            tblMedia.setItems(filteredMediaList); 

            filterCategory.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle == radioBtnFilterId) {
                sortById();
            } else if (newToggle == radioBtnFilterTitle) {
                sortByTitle();
            }
            });
        }

        costLabel.setText(String.format("%.2f", cart.printTotal()));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    private void showFilteredMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
            filteredMediaList.setPredicate(media -> true); 
        } else {
            String lowerCaseFilter = filter.toLowerCase();

            filteredMediaList.setPredicate(media -> {
                if (media.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        }
    }


    void updateButtonBar(Media media) {
        if(media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }

        else {
            btnRemove.setVisible(true);
            if(media instanceof Playable) {
                btnPlay.setVisible(true);
            }
            else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        try {
            final String PLAY_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Play.fxml";
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            media.play();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource (PLAY_FXML_FILE_PATH));
                System.out.println(media.getTitle());
                fxmlLoader.setController(new PlayController(media));

                Parent root = fxmlLoader.load();
                PlayController controller = fxmlLoader.getController();
                controller.setMediaTitle(media.getTitle());

                
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.setTitle("Play");
                stage.show();
        } catch(IOException | PlayerException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        mediaList.remove(media);
        costLabel.setText(String.format("%.2f", cart.printTotal()));
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource (STORE_FXML_FILE_PATH));
                fxmlLoader.setController(new ViewStoreController(store, cart));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Store");
                stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void placeOrderBtnPressed(ActionEvent event) {
        try {
            final String ORDER_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Order.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource (ORDER_FXML_FILE_PATH));
                fxmlLoader.setController(new OrderController());
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Order placed");
                stage.show();

                mediaList.clear();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void sortById() {
        FXCollections.sort(mediaList, Comparator.comparingInt(Media::getId));
        tblMedia.setItems(mediaList);
        }

    private void sortByTitle() {
        FXCollections.sort(mediaList, Comparator.comparing(Media::getTitle));
        tblMedia.setItems(mediaList);
    }
}
