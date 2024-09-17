package javaAccModFirst;

public class Laptop extends Computer{

    public static void main(String[] args) {
        Computer comp = new Computer();

        // Property
        comp.ramProductName = "Kingdon";
        System.out.println(comp.ramProductName);

        // Method
        comp.setRamProductName("Kingmax");
        System.out.println(comp.ramProductName);

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
