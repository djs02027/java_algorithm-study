import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        if (N <= 6) {
            System.out.println(N);
        } else {
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < i; j++) {

                }
            }
        }
    }
}