package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

//    TableView<Part> partTable;
//    TableView<Product> productTable;
//
//    Button addPartButton, modifyPartButton, deletePartButton, searchPartButton, addProductButton;
//    Button modifyProductButton;
//    Button deleteProductButton;
//    Button searchProductButton;
//    TextField searchPartBar;
//    TextField searchProductBar;
//    Label partsLabel;
//    Label productsLabel;

    // Add and Modify Part Elements
//    Button saveButton, cancelButton;
//    Label idLabel, nameLabel, invLabel, priceLabel, maxLabel, minLabel, comLabel;
//    RadioButton inHouse, outSourced;

    // Add and Modify Product Elements
//    Button saveProductButton, cancelProductButton;
//    Label productIDLabel, productNameLabel, productInvLabel, productPriceLabel, productMaxLabel, productMinLabel;
//    RadioButton inHouseProduct, outSourcedProduct;



//    Stage window;
//    Scene mainScene, addPartScene, addProductScene, modifyPartScene, modifyProductScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        window = primaryStage;
//
//
//        //GridPane with 10px padding around edge
//        GridPane mainGrid = new GridPane();
//        mainGrid.setPadding(new Insets(10, 10, 10, 10));
//        mainGrid.setVgap(8);
//        mainGrid.setHgap(10);
//
//        Label mainLabel = new Label("Inventory Management System");
//
//        partsLabel = new Label("Parts");
//
//
//        addPartButton = new Button("Add");
//        modifyPartButton = new Button("Modify");
//        deletePartButton = new Button("Delete");
//        searchPartButton = new Button("Search");
//        searchPartBar = new TextField();
//
//        GridPane.setConstraints(mainLabel, 0, 0);
//        GridPane.setConstraints(partsLabel, 0, 1);
//        GridPane.setConstraints(searchPartBar, 2, 1);
//        GridPane.setConstraints(searchPartButton, 1, 1);
//        GridPane.setConstraints(addPartButton, 0, 2);
//        GridPane.setConstraints(modifyPartButton, 1, 2);
//        GridPane.setConstraints(deletePartButton, 2, 2);
//
//        addPartButton.setOnAction(e->window.setScene(addPartScene));
//
//        productsLabel = new Label("Products");
//        searchProductButton = new Button("Search");
//        searchProductBar = new TextField();
//
//
//        // Products Grid
//        GridPane.setConstraints(productsLabel, 0, 6);
//        GridPane.setConstraints(searchProductButton, 1, 6);
//        GridPane.setConstraints(searchProductBar, 2, 6);
//
//        addProductButton = new Button("Add");
//        modifyProductButton = new Button("Modify");
//        deleteProductButton = new Button("Delete");
//
//        GridPane.setConstraints(addProductButton, 0, 7);
//        GridPane.setConstraints(modifyProductButton, 1, 7);
//        GridPane.setConstraints(deleteProductButton, 2, 7);
//
//
//
//        mainGrid.getChildren().addAll(mainLabel, partsLabel, searchPartButton, searchPartBar, addPartButton,
//                modifyPartButton, deletePartButton, productsLabel, searchProductButton, searchProductBar,
//                addProductButton, modifyProductButton, deleteProductButton);
//        mainScene = new Scene(mainGrid, 700, 500);
//
//
//        // Layout 2
//
//        GridPane addGrid = new GridPane();
//        addGrid.setPadding(new Insets(10, 10, 10, 10));
//        addGrid.setVgap(8);
//        addGrid.setHgap(10);
//
//        addPartScene = new Scene(addGrid, 700, 500);
//
////      Display Scene 1
//        window.setScene(mainScene);
//        window.setTitle("Main Screen");
//        window.show();

        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
