package javaTester;

public class Topic_04_Primitive_Casting {

    public static void main(String[] args) {
        // Ngầm địn= ko mất dữ liệu
//        byte bNumber = 126;
//        System.out.println(bNumber);
//
//        short sNumber = bNumber;
//        System.out.println(sNumber);
//
//        int iNumber = sNumber;
//        System.out.println(iNumber);
//
//        long lNumber = iNumber;
//        System.out.println(lNumber);
//
//        float fNumber = lNumber;
//        System.out.println(fNumber);
//
//        double dNumber = fNumber;
//        System.out.println(dNumber);

        // Tường minhh (nhỏ -> lớn k cần)
        // Lớn -> nhỏ cần (Cast)
        double dNumber = 65432111111111d;
        System.out.println(dNumber);

        float fNumber = (float) dNumber;
        System.out.println(fNumber);

    }

}
