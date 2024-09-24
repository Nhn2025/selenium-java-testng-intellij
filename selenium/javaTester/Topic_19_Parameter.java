package javaTester;

public class Topic_19_Parameter {

    static String fullNameGlobal = "Automation Testing";

    public static void main(String[] args) {

        System.out.println(getFullName());

        // Đối số
        setFullName("Manual Testing");

        System.out.println(getFullName());
    }

    public static void setFullName(String fullName) { // Tham số
        fullNameGlobal = fullName;
    }

    public static String getFullName() {
        return fullNameGlobal;
    }
}
