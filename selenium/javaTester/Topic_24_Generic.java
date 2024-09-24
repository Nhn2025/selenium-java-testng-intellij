package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_24_Generic {

    public static void main(String[] args) {
        // Generic: List chỉ chứa kiểu dữ liệu String
        // E T V X I: the type of elements in this list
        List<String> students = new ArrayList<String>();
        students.add("John");
        students.add("Mary");
        students.add("Peter");

        // non-Generic
        ArrayList address = new ArrayList<>();
        address.add("123 Main st."); // String
        address.add(15); // Integer
        address.add(true); // Booleans
        address.add(15.56); // Float
    }

}
