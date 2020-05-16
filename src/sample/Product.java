package sample;

import javafx.collections.ObservableList;

public class Product {

    private static int idCounter = 1;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private ObservableList<Part> associatedParts;


    public Product(String name, double price, int min, int max, ObservableList<Part> associatedParts) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.stock = 0;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;
    }

    public Product(String name, double price, int stock, int min, int max, ObservableList<Part> associatedParts) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
        if (associatedParts.contains(selectedAssociatedPart)) {
            associatedParts.remove(selectedAssociatedPart);
            return true;
        } else {
            return false;
        }
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public ObservableList<Part> getAllAssociatedParts() {

        return associatedParts;

    }

}
