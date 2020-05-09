package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    private MainController docController;
    ObservableList<Part> partsList = FXCollections.observableArrayList();
    ObservableList<Part> pickedPartsList = FXCollections.observableArrayList();
    Part partClicked;
    @FXML TableView<Part> partTable;
    @FXML private TableColumn<Part, Integer> partId;
    @FXML private TableColumn<Part, String> partName;
    @FXML private TableColumn<Part, Integer> partStock;
    @FXML private TableColumn<Part, Double> partPrice;
    @FXML TableView<Part> pickedPartTable;
    @FXML private TableColumn<Part, Integer> pickedPartId;
    @FXML private TableColumn<Part, String> pickedPartName;
    @FXML private TableColumn<Part, Integer> pickedPartStock;
    @FXML private TableColumn<Part, Double> pickedPartPrice;
    @FXML private TextField id;
    @FXML private TextField name;
    @FXML private TextField inv;
    @FXML private TextField price;
    @FXML private TextField max;
    @FXML private TextField min;
    @FXML private Button cancelButton;
    @FXML private TextField searchBar;

    void setDocController(MainController docController) {
        this.docController = docController;
    }
    public void handleSearch() {
        FilteredList<Part> data = new FilteredList<>(partsList, p -> true);
        data.setPredicate(part -> {
            if (searchBar.getText() == null) {
                return true;
            }
            if (part.getName().contains(searchBar.getText())) {
                return true;
            }
            if (Integer.toString(part.getId()) == searchBar.getText()) {
                return true;
            }
            return false;
        });
        SortedList<Part> output = new SortedList<>(data);
        output.comparatorProperty().bind(partTable.comparatorProperty());
        partTable.setItems(output);
    }

    @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void handleSave(ActionEvent e) {
        if (pickedPartsList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Choose a part associated with this product");
            alert.show();
        } else {
            docController.addProduct(new Product(Integer.parseInt(id.getText()), name.getText(),
                    Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), pickedPartsList));
            final Node previous = (Node) e.getSource();
            final Stage stage = (Stage) previous.getScene().getWindow();
            stage.close();
        }
    }

    public void handleAdd() {

        if (!pickedPartsList.contains(partClicked)) {
            pickedPartTable.getItems().add(partClicked);
            pickedPartsList.add(partClicked);
            partClicked = null;
        }
    }

    public void handleDelete() {
        if (pickedPartsList.contains(partClicked)) {
            pickedPartTable.getItems().remove(partClicked);
            pickedPartsList.remove(partClicked);
            partClicked = null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        pickedPartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        pickedPartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        pickedPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        pickedPartStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partTable.setItems(partsList);
        partTable.setOnMousePressed(event -> partClicked = partTable.getSelectionModel().getSelectedItem());
        pickedPartTable.setOnMousePressed(event -> partClicked = pickedPartTable.getSelectionModel().getSelectedItem());
    }

}
