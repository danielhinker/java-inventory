package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import javax.xml.soap.Text;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {



    @FXML
    TableView<Part> partTable;

    @FXML
    private TableColumn<Part, Integer> partId;

    @FXML
    private TableColumn<Part, String> partName;

    @FXML
    private TableColumn<Part, Integer> partStock;

    @FXML
    private TableColumn<Part, Double> partPrice;


    @FXML
    TableView<Product> productTable;

    @FXML
    private TableColumn<Product, Integer> productId;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Integer> productStock;

    @FXML
    private TableColumn<Product, Double> productPrice;






    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;
    ObservableList<Product> productsList = FXCollections.observableArrayList();
    ObservableList<Part> partsList = FXCollections.observableArrayList();

    public void addPart(Part newPart) {
        partsList.add(newPart);
    }

    public void addProduct(Product newProduct) {

        productsList.add(newProduct);
    }

    public Part lookupPart(int partId) {
        return null;
    }

    public Product lookupProduct(int productId) {
        return null;
    }

    public ObservableList<Part> lookupPart(String partName) {
        return null;
    }

    public ObservableList<Product> lookupProduct(String productName) {
        return null;
    }

    public void updatePart(int index, Part selectedPart) {

    }

    public void updateProduct(int index, Product newProduct) {

    }

    public boolean deletePart(Part selectedPart) {
        return false;
    }

    public boolean deleteProduct(Product selectedProduct) {
        return false;
    }

    public ObservableList<Part> getAllParts() {
        return null;
    }

    public ObservableList<Product> getAllProducts() {
        return null;
    }

//    public ObservableList<Part> addSampleParts() {
//
//        partsList.add(new Part(1, "Part 1", 71.78, 2, 7, 3, true, 1));
//
//        return partsList;
//    }

//    public ObservableList<Product> addSampleProducts() {
//
//        productsList.add(new Product(1, "Part 1", 71.78, 2, 7, 3));
//        productsList.add(new Product(2, "Part 2", 42.89, 3, 10, 1));
//        return productsList;
//    }
    ObservableList<Part> associatedParts;
    Part partClicked;
    Product productClicked;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        partTable.getItems().setAll(addSampleParts());
        partId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partStock.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        partTable.setItems(partsList);

        partTable.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event e) {

                partClicked = partTable.getSelectionModel().getSelectedItem();

            }
        });

        productId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        productPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productStock.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));

        productTable.setItems(productsList);

        productTable.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event e) {

                productClicked = productTable.getSelectionModel().getSelectedItem();
//
            }
        });
    }



    public void handlePartSearch() {
        System.out.println("Search");
//        partTable.

    }

    public void handlePartAdd() {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
                Parent root1 = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                loader.<AddPartController>getController().setDocController(this);
//            AddPartController addPartController = loader.getController();
//            addPartController.setDocController(this);
                stage.show();

            } catch (Exception e) {
                System.out.println((e));
            }

    }

    public void handlePartModify() {
        if (partClicked != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
                Parent root1 = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                loader.<ModifyPartController>getController().setDocController(this);
                ModifyPartController modifyPartController = loader.getController();
                modifyPartController.dataReceived(partClicked);
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
                partTable.getItems().remove(partClicked);
                partClicked = null;
            }
        }
    }

    @FXML
    private TextField partSearchBar;

    @FXML
    private TextField productSearchBar;


    public void handleProductSearch() {

    }

    public void handleProductAdd() {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                loader.<AddProductController>getController().setDocController(this);
                AddProductController controller1 = loader.getController();
                controller1.partTable.getItems().setAll((partsList));
                stage.show();

            } catch (Exception e) {
                System.out.println((e));
            }

    }

    public void handleProductModify() {
        if (productClicked != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                loader.<ModifyProductController>getController().setDocController(this);
                ModifyProductController controller1 = loader.getController();
                controller1.partTable.getItems().setAll((partsList));
                controller1.pickedPartTable.getItems().setAll((productClicked.getAllAssociatedParts()));
                controller1.dataReceived(productClicked);
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

                    productTable.getItems().remove(productClicked);
                    productClicked = null;
                }
        }
    }

    public void dataReceived(Part part) {
        partsList.add(part);

    }


}
