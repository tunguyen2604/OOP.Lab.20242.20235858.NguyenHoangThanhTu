package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OrderController {

    @FXML
    private Button cancelBtn;

    @FXML
    private Label lblPlaying;

    public OrderController() {
        
    }

    @FXML
    void cancelBtnPressed(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}