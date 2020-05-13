package sample;


public class OutSourced extends Part {
    private String companyName;

    public OutSourced(int id, String name, double price, int stock, int min, int max, boolean inhouse, String companyName) {
        super(id, name, price, stock, min, max, inhouse);
        this.companyName = companyName;
    }

    public OutSourced(int id, String name, double price, int min, int max, boolean inhouse, String companyName) {
        super(id, name, price, min, max, inhouse);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
