package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product extends Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    // Setters

    public void setId(int id) {

    }

    public void setName(String name) {

    }

    public void setPrice(double price) {

    }

    public void setStock(int stock) {

    }

    public void setMin(int min) {

    }

    public void setMax(int max) {

    }

    public void addAssociatedPart(Part part) {

    }

    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        return false;
    }



    // Getter Methods

    public int getId() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public double getPrice() {
        return 0;
    }

    public int getStock() {
        return 0;
    }

    public int getMin() {
        return 0;
    }

    public int getMax() {
        return 0;
    }

    public ObservableList<Part> getAllAssociatedParts() {
//        ObservableList<Part> parts = FXCollections.observableArrayList();
//        parts.add()
        return null;

    }

}
