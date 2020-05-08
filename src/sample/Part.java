package sample;

public class Part {

    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private boolean inhouse;
    private int machineId;
    private String companyName;

    // Setters

    public Part(int id, String name, double price, int stock, int min, int max, boolean inhouse, int machineId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.inhouse = inhouse;
        this.machineId = machineId;
        this.companyName = null;
    }

    public Part(int id, String name, double price, int stock, int min, int max, boolean inhouse, String companyName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.inhouse = inhouse;
        this.machineId = -1;
        this.companyName = companyName;
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

    // Getter Methods

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

    public int getMachineId() {
        return machineId;
    }

    public String getCompanyName() {
        return companyName;
    }

}
