package sample;

public abstract class Part {

    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private boolean inhouse;

    public Part(int id, String name, double price, int stock, int min, int max, boolean inhouse) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.inhouse = inhouse;
    }

    public Part(int id, String name, double price, int min, int max, boolean inhouse) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.min = min;
        this.max = max;
        this.inhouse = inhouse;
        this.stock = 0;
    }

    public void setId(int id) {
        this.id = id;
    };

    public void setName(String name) {
        this.name = name;
    };

    public void setPrice(double price) {
        this.price = price;
    };

    public void setStock(int stock) {
        this.stock = stock;
    };

    public void setMin(int min) {
        this.min = min;
    };

    public void setMax(int max) {
        this.max = max;
    };



    public int getId() {
        return id;
    };

    public String getName() {
        return name;
    };

    public double getPrice() {
        return price;
    };

    public int getStock() {
        return stock;
    };

    public int getMin() {
        return min;
    };

    public int getMax() {
        return max;
    };

    public boolean getInHouse() {
        return inhouse;
    }

}
