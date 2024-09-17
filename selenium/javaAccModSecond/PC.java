package javaAccModSecond;

import javaAccModFirst.Computer;

public class PC extends Computer {

    public void showCPUProductName() {
        // Property
        cpuProductName = "Intel";
        System.out.println(cpuProductName);

        // Method
        setCpuProductName("AMD");
        System.out.println(cpuProductName);

        // Property
        vgaSize = 6;
        System.out.println(vgaSize);

        // Method
        setVgaSize(7);
        System.out.println(vgaSize);
    }
}
