package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class AddPartController {

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
    private Button saveButton;

    @FXML
    private RadioButton inhouse;

    @FXML
    private RadioButton outsourced;

    @FXML
    private TextField machineId;

    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void handleSave() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = (Parent) loader.load();

        MainController mainController = loader.getController();
        if (inhouse.isSelected()) {
            mainController.dataReceived(new Part(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), true, Integer.parseInt(machineId.getText())));
        } else {
            mainController.dataReceived(new Part(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), false, company.getText()));
        }
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(root));
        stage2.show();
//        Part tableViewParent = loader.load();
//
//        Scene tableViewScene = new Scene(tableViewParent);





    }



}
