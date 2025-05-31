package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
    private Media media;
    private Store store;
    private Cart cart;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    public ItemController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        System.out.println(cart == null);
        cart.addMedia(media);

    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            final String PLAY_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Play.fxml";
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

}
