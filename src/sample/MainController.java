package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
    ObservableList<Part> partsList = FXCollections.observableArrayList();

    public void addPart(Part newPart) {
        partsList.add(newPart);
    }

    public void addProduct(Product newProduct) {

        productsList.add(newProduct);
    }



    Part partClicked;
    Product productClicked;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        partId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partStock.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        partTable.setItems(partsList);

        partTable.setOnMouseClicked((EventHandler<Event>) e -> partClicked = partTable.getSelectionModel().getSelectedItem());

        productId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        productPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productStock.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));

        productTable.setItems(productsList);

        productTable.setOnMouseClicked((EventHandler<Event>) e -> {

            productClicked = productTable.getSelectionModel().getSelectedItem();
//
        });
    }



    public void handlePartSearch() {
        FilteredList<Part> data = new FilteredList<>(partsList, p -> true);
        data.setPredicate(part -> {
            if (partSearchBar.getText() == null) {
                return true;
            }
            if(part.getName().contains(partSearchBar.getText())) {
                return true;
            }
            if(Integer.toString(part.getId()) == partSearchBar.getText()) {
                return true;
            }
            return false;
        });
        SortedList<Part> output = new SortedList<>(data);
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
        FilteredList<Product> data = new FilteredList<>(productsList, p -> true);

        data.setPredicate(product -> {
            if (productSearchBar.getText() == null) {
                return true;
            }
            if(product.getName().contains(productSearchBar.getText())) {
                return true;
            }
            if(Integer.toString(product.getId()) == productSearchBar.getText()) {
                return true;
            }
            return false;
        });

        SortedList<Product> output = new SortedList<>(data);
        output.comparatorProperty().bind(productTable.comparatorProperty());
        productTable.setItems(output);
    }

    public void handleProductAdd() {
        if (partsList.size() == 0) {
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
                controller1.partTable.getItems().setAll((partsList));
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
