package bai2_vong_lap_trong_java.bai_tap;

public class PrimeNumber100 {
    public static void main(String[] args) {
        boolean check;
        int num = 1;
        String result = "";
        while (num < 100) {
            num++;
            check = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                continue;
            }
            result += num + " ";
        }
        System.out.println(result);
    }


}
