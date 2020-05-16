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

public class ModifyProductController implements Initializable {

    private MainController docController;
    ObservableList<Part> partsList = FXCollections.observableArrayList();
    ObservableList<Part> pickedPartsList = FXCollections.observableArrayList();

    void setDocController(MainController docController) {
        this.docController = docController;
    }

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

    public void handleSearch() {
        FilteredList<Part> data = new FilteredList<>(partsList, p -> true);
        data.setPredicate(part -> {
            if (searchBar.getText() == null) {
                return true;
            }
            if(part.getName().contains(searchBar.getText())) {
                return true;
            }
            if(Integer.toString(part.getId()) == searchBar.getText()) {
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
            double totalPartPrice = pickedPartsList.stream().mapToDouble(Part::getPrice).sum();
            if (pickedPartsList.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Choose a part associated with this product");
                alert.show();
            } else if (name.getText().isEmpty() || price.getText().isEmpty() || inv.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Please make sure there is a value for Name, Inventory Levels, and Price");
                alert.show();
            } else if (Double.parseDouble(price.getText()) < totalPartPrice) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Product must cost more than it's associated parts.");
                alert.show();
            } else {
                int previousCounter = Product.getIdCounter();
                Product.setIdCounter(clickedProductIndex);
                docController.inventory.updateProduct(clickedProductIndex, new Product(name.getText(), Double.parseDouble(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText()), pickedPartsList));
                final Node previous = (Node) e.getSource();
                final Stage stage = (Stage) previous.getScene().getWindow();
                stage.close();
                Product.setIdCounter(previousCounter);
            }
    }

    public void handleAdd() {
        if (!pickedPartsList.contains(partClicked) && partClicked != null) {
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
        partId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partStock.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        pickedPartId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        pickedPartPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        pickedPartName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        pickedPartStock.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        partTable.setItems(partsList);
        partTable.setOnMousePressed(event -> {
            if (partTable.getSelectionModel().getSelectedItem() != null) {
                partClicked = partTable.getSelectionModel().getSelectedItem();
            }
        });
        pickedPartTable.setOnMousePressed(event -> {
            if (pickedPartTable.getSelectionModel().getSelectedItem() != null) {
                partClicked = pickedPartTable.getSelectionModel().getSelectedItem();
            }
        });
    }

    Product clickedProduct;
    int clickedProductIndex;

    public void dataReceived(Product clickedProduct, int clickedProductIndex) {
        this.clickedProduct = clickedProduct;
        this.clickedProductIndex = clickedProductIndex;
        id.setDisable(true);
        id.setText(Integer.toString(Product.getIdCounter()));
        pickedPartsList = clickedProduct.getAllAssociatedParts();


        name.setText(clickedProduct.getName());
        id.setText(Integer.toString(clickedProduct.getId()));
        System.out.println(clickedProduct.getClass());
        price.setText(Double.toString(clickedProduct.getPrice()));
        inv.setText(Integer.toString(clickedProduct.getStock()));
        max.setText(Integer.toString(clickedProduct.getMax()));
        min.setText(Integer.toString(clickedProduct.getMin()));
    }
}
