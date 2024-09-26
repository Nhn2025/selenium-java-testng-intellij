package javaOOP_Abstract;

public interface IAnimal {
    public static final int SUM_NUMBER = 100;

    String getName();

    void setName(String name);

    abstract String getAddress();

    abstract void setAddress(String address);
}
