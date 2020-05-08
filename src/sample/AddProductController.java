package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

//    public ObservableList<Part> getAllParts() {
//        return null;
//    }

    private MainController docController;

    ObservableList<Part> partsList = FXCollections.observableArrayList();

    void setDocController(MainController docController) {
        System.out.println('1');
        this.docController = docController;
        System.out.println(docController);

    }

    Part partClicked;

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
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField inv;

    @FXML
    private TextField price;

    @FXML
    private TextField max;

    @FXML
    private TextField min;

    @FXML
    private Button cancelButton;



        @FXML
    public void handleCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void handleSave(ActionEvent e) {

        docController.addProduct(new Product(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(inv.getText()), Integer.parseInt(min.getText()), Integer.parseInt(max.getText())));


        final Node previous = (Node) e.getSource();
        final Stage stage = (Stage) previous.getScene().getWindow();
        stage.close();

    }

    public void handleAdd() {

    }

    public void handleDelete() {

    }

    public ObservableList<Part> addSampleParts() {

        partsList.add(new Part(1, "Part 1", 71.78, 2, 7, 3, true, 1));

        return partsList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        partId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));

        partPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));

        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));

        partStock.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
//        System.out.println(docController.addSampleParts());

        partTable.setItems(addSampleParts());

//        partTable.setOnMouseClicked(new EventHandler() {
//            @Override
//            public void handle(Event e) {
//
//                partClicked = partTable.getSelectionModel().getSelectedItem();
////                System.out.println(partClicked);
//            }
//        });
    }
}
