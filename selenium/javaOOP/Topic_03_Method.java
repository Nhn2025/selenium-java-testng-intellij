package javaOOP;

public class Topic_03_Method {

    void showCarName() {
        System.out.println("Huyndai Tucson");
    }

    static void showCarColor() {
        System.out.println("White");
    }

    public static void main(String[] args) {
        // Gọi vào trong 1 hàm static khác
        showCarColor();
        Topic_03_Method.showCarColor();

        // Gọi qua instance/ object
        Topic_03_Method obj = new Topic_03_Method();
        obj.showCarName();
    }

}
