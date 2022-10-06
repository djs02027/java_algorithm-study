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

//          해당 날짜에 받지 않는다면 0이 아니라 이전에 정산받았던 금액이 누적되므로..
            dp[i+1]=Math.max(dp[i+1],dp[i]);
        }
        System.out.println(dp[N+1]);


    }
}