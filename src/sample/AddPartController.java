package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class AddPartController {

    private MainController docController;



    void setDocController(MainController docController) {
        this.docController = docController;

    }

    @FXML
    private Button cancelButton;

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField inv;
    @FXML
    private TextField price;
    @FXML
    private TextField max;
    @FXML
    private TextField min;
    @FXML
    private TextField company;

    @FXML
    private RadioButton inhouse;

    @FXML
    private RadioButton outsourced;

    public void inhouseClicked() {
        company.setDisable(true);
        machineId.setDisable(false);
    }

    public void outsourcedClicked() {
        machineId.setDisable(true);
        company.setDisable(false);
    }



    @FXML
    private TextField machineId;

    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void handleSave(ActionEvent e) throws IOException {
        if (!inhouse.isSelected() && !outsourced.isSelected()) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Error");
         alert.setHeaderText("Choose if part is in-house or out-sourced");
         alert.show();

        } else {
            if (inhouse.isSelected()) {
                docController.addPart(new Part(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), true, Integer.parseInt(machineId.getText())));
            } else {
                docController.addPart(new Part(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), false, company.getText()));
            }

            final Node previous = (Node) e.getSource();
            final Stage stage = (Stage) previous.getScene().getWindow();
            stage.close();

        }
    }



}
