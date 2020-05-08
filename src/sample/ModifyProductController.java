package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ModifyProductController {

    @FXML
    private Button cancelButton;

    //    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void handleAdd() {

    }
    public void handleDelete() {

    }
    public void handleSave() {

    }
}
