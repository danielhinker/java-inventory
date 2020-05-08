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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

import javax.xml.soap.Text;
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

    public ObservableList<Part> addSampleParts() {

        partsList.add(new Part(1, "Part 1", 71.78, 2, 7, 3, true, 1));

        return partsList;
    }

    public ObservableList<Product> addSampleProducts() {

        productsList.add(new Product(1, "Part 1", 71.78, 2, 7, 3));
        productsList.add(new Product(2, "Part 2", 42.89, 3, 10, 1));
        return productsList;
    }
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

        partTable.setItems(addSampleParts());

        partTable.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event e) {

                partClicked = partTable.getSelectionModel().getSelectedItem();
//                associatedParts.
//                System.out.println(partClicked);
            }
        });

        productId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        productPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productStock.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));

        productTable.setItems(addSampleProducts());

        productTable.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event e) {

                productClicked = productTable.getSelectionModel().getSelectedItem();
//                System.out.println(partClicked);
            }
        });
    }



    public void handlePartSearch() {
        System.out.println("Search");
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
        System.out.println("partDelete");
        if (partClicked != null) {
            partTable.getItems().remove(partClicked);
            partClicked = null;
        }
    }

    @FXML
    private TextField partSearchBar;

    @FXML
    private TextField productSearchBar;

    public void handleProductSearch() {
        for (int i = 0; i < productsList.size(); i++) {
        if (productsList[i].getName() == productSearchBar.getText()) {
            partsList.filtered()
        }
        }
    }

    public void handleProductAdd() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Project");
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

    public void dataReceived(Part part) {
        partsList.add(part);
//        System.out.println(text);
    }


}
