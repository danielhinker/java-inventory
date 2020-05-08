package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    private Part clickedPart;

    private MainController docController;

    void setDocController(MainController docController) {
        this.docController = docController;
    }

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
    private TextField machineId;

    @FXML
    private RadioButton inhouse;

    @FXML
    RadioButton outsourced;

    @FXML
    private Button cancelButton;

    //    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void handleSave(ActionEvent e) {

        docController.partsList.remove(clickedPart);
        if (inhouse.isSelected()) {
            docController.addPart(new Part(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), true, Integer.parseInt(machineId.getText())));
        } else {
            docController.addPart(new Part(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), false, company.getText()));
        }

        final Node previous = (Node) e.getSource();
        final Stage stage = (Stage) previous.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void dataReceived(Part clickedPart) {
        this.clickedPart = clickedPart;
    }
}
