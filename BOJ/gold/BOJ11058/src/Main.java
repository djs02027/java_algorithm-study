import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[101];
        for (int i = 0; i < 7; i++) {
            dp[i] = i;
        }


        for (int i = 7; i < dp.length; i++) {
            dp[i]=dp[i-1]+1;
            for (int j = 0; j < 3; j++) {
                dp[i] = Math.max(dp[i], dp[i - 3 - j] * (2 + j));

            }
        }
        System.out.println(dp[N]);
    }
}