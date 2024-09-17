package javaAccModSecond;

import javaAccModFirst.Computer;

public class Workstation {

    public static void main(String[] args) {
        Computer comp = new Computer();

        // Property
        comp.vgaSize = 6;
        System.out.println(comp.vgaSize);

        // Method
        comp.setVgaSize(7);
        System.out.println(comp.vgaSize);
    }

}
