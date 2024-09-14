package javaTester;

import org.testng.annotations.Test;

public class Topic_08_Getter_Setter {
    private String fullName;
    private String carName;
    private String carType;
    private String carColor;

    @Test
    public void testGetterSetter() {
        setFullName("Automation Testing");
        System.out.println(getFullName());
        setFullName("Manual Testing");
        System.out.println(getFullName());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarName() {
        return carName;
    }

    public Topic_08_Getter_Setter(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Topic_08_Getter_Setter{" +
                "fullName='" + fullName + '\'' +
                ", carName='" + carName + '\'' +
                ", carType='" + carType + '\'' +
                ", carColor='" + carColor + '\'' +
                '}';
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    // Constructer
    public Topic_08_Getter_Setter(String fullName, String carName, String carType, String carColor) {
        this.fullName = fullName;
        this.carName = carName;
        this.carType = carType;
        this.carColor = carColor;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}