package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {

    private MainController docController;

    void setDocController(MainController docController) {
        this.docController = docController;
    }

    @FXML private Button cancelButton;

    @FXML private TextField id;
    @FXML private TextField name;
    @FXML private TextField inv;
    @FXML private TextField price;
    @FXML private TextField max;
    @FXML private TextField min;
    @FXML private TextField company;
    @FXML private RadioButton inhouse;
    @FXML private RadioButton outsourced;

    public void inhouseClicked() {
        company.setDisable(true);
        machineId.setDisable(false);
    }

    public void outsourcedClicked() {
        machineId.setDisable(true);
        company.setDisable(false);
    }

    @FXML private TextField machineId;

    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void handleSave(ActionEvent e) {
        if (!inhouse.isSelected() && !outsourced.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Choose if part is in-house or out-sourced");
            alert.show();
        } else if (name.getText().isEmpty() || price.getText().isEmpty() || inv.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Please make sure there is a value for Name, Inventory Levels, and Price");
                alert.show();
        } else {
            if (inhouse.isSelected()) {
                docController.inventory.addPart(new InHouse(name.getText(),
                        Double.parseDouble(price.getText()), Integer.parseInt(inv.getText()),
                        Integer.parseInt(min.getText()), Integer.parseInt(max.getText()),
                        true, Integer.parseInt(machineId.getText())));
            } else {
                docController.inventory.addPart(new OutSourced(name.getText(),
                        Double.parseDouble(price.getText()), Integer.parseInt(inv.getText()),
                        Integer.parseInt(min.getText()), Integer.parseInt(max.getText()),
                        false, company.getText()));
            }
            final Node previous = (Node) e.getSource();
            final Stage stage = (Stage) previous.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.id.setDisable(true);
        this.id.setText(Integer.toString(Part.getIdCounter()));
    }
}
