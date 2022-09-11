import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] dp = new int [K+1];
        Arrays.fill(dp,10001);
        int [] coinList = new int[N];
        for (int i=0; i<N;i++){
            int coin = sc.nextInt();
            coinList[i]=coin;

        }

        dp[0]=0;

        for (int i=0; i< coinList.length; i++){
            for(int j=coinList[i]; j<K+1; j++){
                dp[j]=Math.min(dp[j],dp[j-coinList[i]]+1);

            }
        }
        if (dp[K]==10001){
            System.out.println(-1);
        }else {
            System.out.println(dp[K]);
        }


    }
}