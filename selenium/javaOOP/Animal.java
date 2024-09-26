package javaOOP;

// Abstract Class
// Template
public abstract class Animal {

    // Variable
    String animalName = "Dog";

    // Method
    // Ko có phần thân (body)
    // public, protected
    // Bắt buộc các class con phải override các hàm này lại
    protected abstract void setAnimalName();

}
