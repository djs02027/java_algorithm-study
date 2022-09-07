import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Long S = sc.nextLong();
        int total = 0;
        long sum = 0;
        int i;
        for (i = 1; ; i++) {
            sum += i;
            if (sum > S) {
                break;
            }
            total += 1;

        }
        System.out.println(total);


    }
}