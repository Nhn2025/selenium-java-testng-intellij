package javaOOP;

public interface IComputer {

    public void showComputerPerfomance();

    // Nếu không gán từ khóa là abstract cho hàm thì tự hiêu đây vẫn là 1 hàm abstract
    // Mọi hàm đều là abstract
    // Abstract Method
    public abstract void showComputerRam();

}
