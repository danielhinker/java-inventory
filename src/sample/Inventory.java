package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;


public class Inventory {
    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public void addPart(Part newPart) {
        allParts.add(newPart);
    }

    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    public Part lookupPart(int PartId) {
        return allParts.get(PartId);
    }

    public Product lookupProduct(int productId) {
        return allProducts.get(productId);
    }

    public ObservableList<Part> lookupPart(String partName) {
        FilteredList<Part> data = new FilteredList<>(getAllParts(), p -> true);
        data.setPredicate(part -> {
            if (partName == null) {
                return true;
            }
            if(part.getName().contains(partName)) {
                return true;
            }
            if(Integer.toString(part.getId()) == partName) {
                return true;
            }
            return false;
        });
        SortedList<Part> output = new SortedList<>(data);
        return output;

    }

    public ObservableList<Product> lookupProduct(String productName) {
        FilteredList<Product> data = new FilteredList<>(getAllProducts(), p -> true);
        data.setPredicate(product -> {
            if (productName == null) {
                return true;
            }
            if(product.getName().contains(productName)) {
                return true;
            }
            if(Integer.toString(product.getId()) == productName) {
                return true;
            }
            return false;
        });
        SortedList<Product> output = new SortedList<>(data);
        return output;
    }

    public void updatePart(int index, Part selectedPart) {

        allParts.set(index, selectedPart);

    }

    public void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    }

    public boolean deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
        return true;
    }

    public boolean deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
        return true;
    }

    public ObservableList<Part> getAllParts() {
        return allParts;
    }

    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}
