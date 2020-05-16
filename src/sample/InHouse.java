package sample;

public class InHouse extends Part {
    private int machineId;

    public InHouse(String name, double price, int stock, int min, int max, boolean inhouse, int machineId) {
        super(name, price, stock, min, max, inhouse);
        this.machineId = machineId;
    }

    public InHouse(String name, double price, int min, int max, boolean inhouse, int machineId) {
        super(name, price, min, max, inhouse);
        this.machineId = machineId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

}
