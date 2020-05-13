package sample;

import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    Inventory inventory = new Inventory();

    @FXML TableView<Part> partTable;
    @FXML private TableColumn<Part, Integer> partId;
    @FXML private TableColumn<Part, String> partName;
    @FXML private TableColumn<Part, Integer> partStock;
    @FXML private TableColumn<Part, Double> partPrice;
    @FXML TableView<Product> productTable;
    @FXML private TableColumn<Product, Integer> productId;
    @FXML private TableColumn<Product, String> productName;
    @FXML private TableColumn<Product, Integer> productStock;
    @FXML private TableColumn<Product, Double> productPrice;

    Part partClicked;
    int partClickedIndex;
    Product productClicked;
    int productClickedIndex;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        partId.setCellValueFactory(new PropertyValueFactory<>("id"));
        partPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        partName.setCellValueFactory(new PropertyValueFactory<>("name"));
        partStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partTable.setItems(inventory.getAllParts());
        partTable.setOnMouseClicked((EventHandler<Event>) e -> {
            partClicked = partTable.getSelectionModel().getSelectedItem();
            partClickedIndex = partTable.getSelectionModel().getSelectedIndex();
        });
        productId.setCellValueFactory(new PropertyValueFactory<>("id"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        productName.setCellValueFactory(new PropertyValueFactory<>("name"));
        productStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productTable.setItems(inventory.getAllProducts());
        productTable.setOnMouseClicked((EventHandler<Event>) e -> {
            productClicked = productTable.getSelectionModel().getSelectedItem();
            productClickedIndex = productTable.getSelectionModel().getSelectedIndex();
        });
    }

    public void handlePartSearch() {
            SortedList<Part> output = (SortedList<Part>) inventory.lookupPart(partSearchBar.getText());
            output.comparatorProperty().bind(partTable.comparatorProperty());
            partTable.setItems(output);

    }

    public void handlePartAdd() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
                Parent root1 = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                loader.<AddPartController>getController().setDocController(this);
                stage.show();
            } catch (Exception e) {
                System.out.println((e));
            }
    }

    public void handlePartModify() {
        if (partClicked != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
                Parent root1 = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                loader.<ModifyPartController>getController().setDocController(this);
                ModifyPartController modifyPartController = loader.getController();
                modifyPartController.dataReceived(partClicked, partClickedIndex);
                stage.show();
            } catch (Exception e) {
                System.out.println((e));
            }
        }
    }

    public void handlePartDelete() {
        if (partClicked != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Warning!");
            alert.setHeaderText("Are you sure you want to delete this part?");
            Optional<ButtonType> alertButton = alert.showAndWait();
            if (alertButton.get() == ButtonType.OK) {
                inventory.deletePart(partClicked);

                inventory.getAllProducts().forEach(e -> {
                    if (e.getAllAssociatedParts().get(0) == partClicked && e.getAllAssociatedParts().size() == 1) {
                        inventory.deleteProduct(e);
                    }
                });

            }
                partClicked = null;
            }
        }


    @FXML private TextField partSearchBar;
    @FXML private TextField productSearchBar;

    public void handleProductSearch() {
        SortedList<Product> output = (SortedList<Product>) inventory.lookupProduct(productSearchBar.getText());
        output.comparatorProperty().bind(productTable.comparatorProperty());
        productTable.setItems(output);
    }

    public void handleProductAdd() {
        if (inventory.getAllParts().size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Need parts before adding a product");
            alert.show();
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                loader.<AddProductController>getController().setDocController(this);
                AddProductController controller1 = loader.getController();
                controller1.partTable.getItems().setAll((inventory.getAllParts()));
                stage.show();

            } catch (Exception e) {
                System.out.println((e));
            }
        }

    }

    public void handleProductModify() {
        if (productClicked != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                loader.<ModifyProductController>getController().setDocController(this);
                ModifyProductController controller1 = loader.getController();
                controller1.partTable.getItems().setAll((inventory.getAllParts()));
                controller1.pickedPartTable.getItems().setAll((productClicked.getAllAssociatedParts()));
                controller1.dataReceived(productClicked, productClickedIndex);
                stage.show();

            } catch (Exception e) {
                System.out.println((e));
            }
        }
    }

    public void handleProductDelete() {


        if (productClicked != null) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Warning!");
                alert.setHeaderText("Are you sure you want to delete this product?");
                Optional<ButtonType> alertButton = alert.showAndWait();
                if (alertButton.get() == ButtonType.OK) {

                    inventory.deleteProduct(productClicked);

                    productClicked = null;
                }
        }
    }

    public void handleExit() {
        System.exit(0);
    }
}
