import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int [] dp = new int[N+2];

        for (int i = 1; i <= N; i++) {
            int time = sc.nextInt();
            int money = sc.nextInt();
            if(time+i<=N+1){
                dp[time+i]=Math.max(dp[i]+money,dp[time+i]);
            }


            dp[i+1]=Math.max(dp[i+1],dp[i]);
        }
        System.out.println(dp[N+1]);


    }
}