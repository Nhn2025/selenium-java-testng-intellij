package javaAccModFirst;

public class Computer {
    // Property
    private int ssdSize;

    String ramProductName;

    protected String cpuProductName;

    public int vgaSize;

    // Method
    private void setSsdSize(int Ssd_size) {
        ssdSize = Ssd_size;
    }

    void setRamProductName(String ramProduct) {
        ramProductName = ramProduct;
    }

    protected void setCpuProductName(String cpuProduct) {
        ramProductName = cpuProduct;
    }

    public void setVgaSize(int vgaSize) {
        this.vgaSize = vgaSize;
    }

    public static void main(String[] args) {
        Computer comp = new Computer();

        // Property
        comp.ramProductName = "Kingdon";
        System.out.println(comp.ramProductName);

        // Method
        comp.setRamProductName("Kingmax");
        System.out.println(comp.ramProductName);

        comp.ssdSize = 500;
        System.out.println(comp.ssdSize);

        comp.setSsdSize(600);
        System.out.println(comp.ssdSize);

        // Property
        comp.cpuProductName = "Intel";
        System.out.println(comp.cpuProductName);

        // Method
        comp.setCpuProductName("AMD");
        System.out.println(comp.cpuProductName);

        // Property
        comp.vgaSize = 6;
        System.out.println(comp.vgaSize);

        // Method
        comp.setVgaSize(7);
        System.out.println(comp.vgaSize);
    }
}
