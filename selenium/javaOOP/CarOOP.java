package javaOOP;

import org.checkerframework.checker.units.qual.C;

public class CarOOP {
    // Thuộc tính
    private String carCompany;
    private String carType;
    private String fuelType;
    private Float mileAge;
    private Double carPrice;

    public CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
        this.carCompany = carCompany;
        this.carType = carType;
        this.fuelType = fuelType;
        this.mileAge = mileAge;
        this.carPrice = carPrice;
    }

    protected String getCarCompany() {
        return carCompany;
    }

    protected void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    protected String getCarType() {
        return carType;
    }

    protected void setCarType(String carType) {
        this.carType = carType;
    }

    protected String getFuelType() {
        return fuelType;
    }

    protected void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    protected Float getMileAge() {
        return mileAge;
    }

    protected void setMileAge(Float mileAge) {
        this.mileAge = mileAge;
    }

    protected Double getCarPrice() {
        return carPrice;
    }

    protected void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    protected void showCarInfor() {
        System.out.println("Car company = " + carCompany);
        System.out.println("Car type = " + carType);
        System.out.println("Fuel type = " + fuelType);
        System.out.println("Mile age = " + mileAge);
        System.out.println("Car price = " + carPrice);
    }

    public static void main(String[] args) {
        // Honda
        CarOOP honda = new CarOOP("Honda", "City", "Petrol", 150f, 1000d);

        // Toyota
        CarOOP toyota = new CarOOP("Toyota", "Carmy", "Diesel", 200f, 6000d);

    }

}
