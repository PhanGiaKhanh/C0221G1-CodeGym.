package L2_VongLapTrongJava.BaiTap;

public class PrimeNumber20 {
    public static void main(String[] args) {
        byte count = 0;
        boolean check;
        int num = 1;
        String result = "";
        while (count < 20) {
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
            count++;

        }
        System.out.println(result);
    }
}
