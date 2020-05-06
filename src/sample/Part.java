package sample;

public abstract class Part {

    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    // Setters

    public abstract void setId(int id);

    public abstract void setName(String name);

    public abstract void setPrice(double price);

    public abstract void setStock(int stock);

    public abstract void setMin(int min);

    public abstract void setMax(int max);

    // Getter Methods

    public abstract int getId();

    public abstract String getName();

    public abstract double getPrice();

    public abstract int getStock();

    public abstract int getMin();

    public abstract int getMax();

}
