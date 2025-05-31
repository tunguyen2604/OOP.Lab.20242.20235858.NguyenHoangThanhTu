package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.media.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PlayController {
    private Media media;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label lblPlaying;

    public PlayController(Media media) {
        this.media = media;
        System.out.println(media == null);
    }

    public void setMediaTitle(String title) {
        System.out.println(media == null);
        lblPlaying.setText("Playing: " + title);
    }

    @FXML
    void cancelBtnPressed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}