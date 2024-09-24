package javaOOP_Overloading;

public class Overloading {
    private int firstNumber;
    private int secondNumber;

    public void sumNumber() {
        System.out.println(this.firstNumber + this.secondNumber);
    }

    public void sumNumber(int number) {
        System.out.println(number + (number * 0.1));
    }

    public void sumNumber(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    public void sumNumber(float firstNumber, float secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    public void sumNumber(float firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    public static void main(String[] args) {
        Overloading over = new Overloading();
        over.sumNumber(15);
    }

}
