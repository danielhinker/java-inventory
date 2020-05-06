package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Button addPartButton;
    Button modifyPartButton;
    Button deletePartButton;
    Button searchButton;
    Button addProductButton;
    Button modifyProductButton;
    Button deleteProductButton;
    Button searchProductButton;
    TextField searchPartBar;
    TextField searchProductBar;

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;


        primaryStage.setTitle("Title of Window");
        addPartButton = new Button("Add");
        addPartButton.setOnAction(e->window.setScene(scene2));

        // Layout 1 - children are laid out in vertical column


        modifyPartButton = new Button("Modify");
        deletePartButton = new Button("Delete");
        searchButton = new Button("Search");
        addProductButton = new Button("Add");
        modifyProductButton = new Button("Modify");
        deleteProductButton = new Button("Delete");
        searchProductButton = new Button("Search");

//        addPartButton.setOnAction(e->System.out.println(e));


        //This class will handle the button events
//        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(addPartButton);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
