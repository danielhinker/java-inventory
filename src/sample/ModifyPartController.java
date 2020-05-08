package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    @FXML
    private Button cancelButton;

    //    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void handleSave() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
