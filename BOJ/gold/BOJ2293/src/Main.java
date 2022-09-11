import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//      0 1 2 3 4 5 6 7 8 9 10
//  1   1 1 1 1 1 1 1 1 1 1 1
//  2   0 0 1 1 2 2 3 3 4 4 5
//  5   0 0 0 0 0 1 1 2 2 3 4
// ===========================
//      1 1 2 2 3 4 5 6 7 8 10
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coinList = new int[N];
        int[] dp = new int[K+1];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            coinList[i] = num;

        }
        dp[0] = 1;

        for (int i = 0; i < coinList.length; i++) {
            for(int j=coinList[i];j<K+1;j++){
                dp[j]+=dp[j-coinList[i]];
            }

        }
        System.out.println(dp[K]);


    }


}