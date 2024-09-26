package javaOOP_Abstract;

public abstract class Computer {

    // Non- abstract (Normal)
    public void showCPU() {
        System.out.println("Intel CPU");
    }

    // Abstract
    protected abstract void setRam();

    private void showGPU() {

    }

    void showHDD() {

    }

}
