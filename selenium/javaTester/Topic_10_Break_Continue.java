package javaTester;

public class Topic_10_Break_Continue {

    public static void main(String[] args) {

        // Nested for
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Lần chạy của i (for trên) = " + i);

            // i = 1
            // Mõi 1 lầm chạy của for trên sẽ apply cho tất cả các lầm chạy của for dưới này
            for (int j = 1; j <= 5 ; j++) {
                if (j == 4)
                    continue;
                System.out.println("j = " + j);
            }

            // 1, 2, 3, 5
        }
    }

}
