package javaOOP;

// Abstract Class
// Template
public abstract class Annimal {

    // Variable
    String annimalName = "Dog";

    // Method
    // Ko có phần thân (body)
    // public, protected
    // Bắt buộc các class con phải override các hàm này lại
    protected abstract void setAnnimalName();


}
