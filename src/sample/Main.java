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
    Scene mainScene, addScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;


        //GridPane with 10px padding around edge
        GridPane mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(10, 10, 10, 10));
        mainGrid.setVgap(8);
        mainGrid.setHgap(10);

        Label mainLabel = new Label("Inventory Management System");

        partsLabel = new Label("Parts");


        addPartButton = new Button("Add   ");
        modifyPartButton = new Button("Modify");
        deletePartButton = new Button("Delete");
        searchPartButton = new Button("Search");
        searchPartBar = new TextField();

        GridPane.setConstraints(mainLabel, 0, 0);
        GridPane.setConstraints(partsLabel, 0, 1);
        GridPane.setConstraints(searchPartBar, 2, 1);
        GridPane.setConstraints(searchPartButton, 1, 1);
        GridPane.setConstraints(addPartButton, 0, 2);
        GridPane.setConstraints(modifyPartButton, 1, 2);
        GridPane.setConstraints(deletePartButton, 2, 2);

        addPartButton.setOnAction(e->window.setScene(addScene));

        productsLabel = new Label("Products");
        searchProductButton = new Button("Search");
        searchProductBar = new TextField();


        // Products Grid
        GridPane.setConstraints(productsLabel, 0, 6);
        GridPane.setConstraints(searchProductButton, 1, 6);
        GridPane.setConstraints(searchProductBar, 2, 6);

        addProductButton = new Button("Add");
        modifyProductButton = new Button("Modify");
        deleteProductButton = new Button("Delete");

        GridPane.setConstraints(addProductButton, 0, 7);
        GridPane.setConstraints(modifyProductButton, 1, 7);
        GridPane.setConstraints(deleteProductButton, 2, 7);


        // Layout 1 - children are laid out in vertical column
//        VBox layout1 = new VBox(20);
//        layout1.getChildren().addAll(label1, addPartButton);

        mainGrid.getChildren().addAll(mainLabel, partsLabel, searchPartButton, searchPartBar, addPartButton,
                modifyPartButton, deletePartButton, productsLabel, searchProductButton, searchProductBar,
                addProductButton, modifyProductButton, deleteProductButton);
        mainScene = new Scene(mainGrid, 700, 500);


//        modifyPartButton.setOnAction(e->window.setScene(scene1));

//        StackPane layout = new StackPane();
//        layout.getChildren().add(addPartButton);
//        Scene scene = new Scene(layout, 300, 250);
//        primaryStage.setScene(scene);

        // Layout 2
//        StackPane layout2 = new StackPane();
//        layout2.getChildren().add(modifyPartButton);

        //GridPane with 10px padding around edge
        GridPane addGrid = new GridPane();
        addGrid.setPadding(new Insets(10, 10, 10, 10));
        addGrid.setVgap(8);
        addGrid.setHgap(10);

        addScene = new Scene(addGrid, 700, 500);

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
