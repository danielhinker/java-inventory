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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.net.URL;
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


    ObservableList<Product> productsList = FXCollections.observableArrayList();



    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;

    public void addPart(Part newPart) {

    }

    public void addProduct(Product newProduct) {

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

    public ObservableList<Part> addSampleParts() {
        ObservableList<Part> partsList = FXCollections.observableArrayList();
        partsList.add(new Part(1, "Part 1", 71.78, 2, 7, 3, true, -1, "1"));
        partsList.add(new Part(2, "Part 2", 42.89, 3, 10, 1, false, 3, "Apple"));
        return partsList;
    }

    Part partClicked;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        partTable.getItems().setAll(addSampleParts());
        partId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partStock.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        partTable.setItems(addSampleParts());

        partTable.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {

                partClicked = partTable.getSelectionModel().getSelectedItem();
//                System.out.println(partClicked);
            }
        });
    }



    public void handlePartSearch() {
        System.out.println("Search");
    }

    public void handlePartAdd() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println((e));
        }
    }

    public void handlePartModify() {
        if (partClicked != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));


                stage.show();

            } catch (Exception e) {
                System.out.println((e));
            }
        }
    }

    public void handlePartDelete() {
        System.out.println("partDelete");
    }

    public void handleProductSearch() {
        System.out.println("productSearch");
    }

    public void handleProductAdd() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println((e));
        }
    }
    public void handleProductModify() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println((e));
        }
    }

    public void handleProductDelete() {
        System.out.println("productDelete");
    }


}
