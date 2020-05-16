package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ModifyPartController implements Initializable {

    private Part clickedPart;
    private int clickedPartIndex;
    private MainController docController;
    void setDocController(MainController docController) {
        this.docController = docController;
    }
    @FXML private TextField id;
    @FXML private TextField name;
    @FXML private TextField inv;
    @FXML private TextField price;
    @FXML private TextField max;
    @FXML private TextField min;
    @FXML private TextField company;
    @FXML private TextField machineId;
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


    @FXML
    private Button cancelButton;

    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void handleSave(ActionEvent e) {
        if (name.getText().isEmpty() || price.getText().isEmpty() || inv.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Please make sure there is a value for Name, Inventory Levels, and Price");
            alert.show();
        } else if (inhouse.isSelected()) {
            docController.inventory.updatePart(clickedPartIndex, new InHouse(name.getText(),
                    Double.parseDouble(price.getText()), Integer.parseInt(inv.getText()),
                    Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), true,
                    Integer.parseInt(machineId.getText())));
        } else {
            docController.inventory.updatePart(clickedPartIndex, new OutSourced(name.getText(),
                    Double.parseDouble(price.getText()), Integer.parseInt(inv.getText()),
                    Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), false,
                    company.getText()));
            final Node previous = (Node) e.getSource();
            final Stage stage = (Stage) previous.getScene().getWindow();
            stage.close();
        }

    }

    public void dataReceived(Part clickedPart, int clickedPartIndex) {

        this.clickedPart = clickedPart;
        this.clickedPartIndex = clickedPartIndex;
        this.id.setDisable(true);

        name.setText(clickedPart.getName());
        id.setText(Integer.toString(clickedPart.getId()));
        System.out.println(clickedPart.getClass());

        if (clickedPart.getInHouse() == false) {
            outsourced.setSelected(true);
            machineId.setDisable(true);
            company.setText(((OutSourced) clickedPart).getCompanyName());
        } else {
            inhouse.setSelected(true);
            company.setDisable(true);
            machineId.setText(Integer.toString(((InHouse) clickedPart).getMachineId()));
        }
        price.setText(Double.toString(clickedPart.getPrice()));
        inv.setText(Integer.toString(clickedPart.getStock()));
        max.setText(Integer.toString(clickedPart.getMax()));
        min.setText(Integer.toString(clickedPart.getMin()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
