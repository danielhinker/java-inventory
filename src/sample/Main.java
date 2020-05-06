package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button addPartButton;
    Button modifyPartButton;
    Button deletePartButton;
    Button searchPartButton;
    Button addProductButton;
    Button modifyProductButton;
    Button deleteProductButton;
    Button searchProductButton;
    TextField searchPartBar;
    TextField searchProductBar;
    Label partsLabel;
    Label productsLabel;

    Stage window;
    Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;


        //GridPane with 10px padding around edge
        GridPane mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(20, 20, 20, 20));
        mainGrid.setVgap(16);
        mainGrid.setHgap(20);

        GridPane partsGrid = new GridPane();
        partsGrid.setPadding(new Insets(10, 10, 10, 10));
        partsGrid.setVgap(8);
        partsGrid.setHgap(10);
        GridPane.setConstraints(partsGrid, 0, 2);

        GridPane productsGrid = new GridPane();
        productsGrid.setPadding(new Insets(10, 10, 10, 10));
        productsGrid.setVgap(8);
        productsGrid.setHgap(10);
        GridPane.setConstraints(productsGrid, 1, 2);

        Label mainLabel = new Label("Inventory Management System");


        // Parts Grid

        GridPane.setConstraints(mainLabel, 0, 0);

        addPartButton = new Button("Add   ");
        modifyPartButton = new Button("Modify");
        deletePartButton = new Button("Delete");
        searchPartButton = new Button("Search");
        searchPartBar = new TextField();

        GridPane.setConstraints(searchPartBar, 1, 1);
//        GridPane.setColumnSpan(searchPartBar, 1);
//        GridPane.setRowSpan(searchPartBar, 1);
        GridPane.setConstraints(searchPartButton, 0, 1);

        GridPane.setConstraints(addPartButton, 0, 2);
        GridPane.setConstraints(modifyPartButton, 1, 2);
        GridPane.setConstraints(deletePartButton, 2, 2);

//        addPartButton.setOnAction(e->window.setScene(scene2));


        // Products Grid
        addProductButton = new Button("Add");
        modifyProductButton = new Button("Modify");
        deleteProductButton = new Button("Delete");
        searchProductButton = new Button("Search");

        GridPane.setConstraints(addProductButton, 0, 3);
        GridPane.setConstraints(modifyProductButton, 1, 3);
        GridPane.setConstraints(deleteProductButton, 2, 3);


        // Layout 1 - children are laid out in vertical column
//        VBox layout1 = new VBox(20);
//        layout1.getChildren().addAll(label1, addPartButton);

        partsGrid.getChildren().addAll(searchPartBar, searchPartButton, addPartButton, modifyPartButton, deletePartButton);
//        productsGrid.getChildren().addAll(addProductButton, modifyProductButton, deleteProductButton);
        mainGrid.getChildren().addAll(mainLabel, partsGrid, productsGrid);
        mainScene = new Scene(mainGrid, 700, 500);

        // Button 2

//        modifyPartButton.setOnAction(e->window.setScene(scene1));

        // Layout 2
//        StackPane layout2 = new StackPane();
//        layout2.getChildren().add(modifyPartButton);
//        scene2 = new Scene(layout2, 600, 300);

//         Display Scene 1
        window.setScene(mainScene);
        window.setTitle("Main Screen");
        window.show();

//        deletePartButton = new Button("Delete");
//        searchButton = new Button("Search");


//        addPartButton.setOnAction(e->System.out.println(e));


        //This class will handle the button events
//        button.setOnAction(this);

//        StackPane layout = new StackPane();
//        layout.getChildren().add(addPartButton);
//        Scene scene = new Scene(layout, 300, 250);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
