import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int [] dp =new int [N+2];
        int [] T = new int [N+1];
        int [] P =new int [N+1];

        for (int i = 0; i < N; i++) {
            String [] tmp= br.readLine().split(" ");
            int t = Integer.parseInt(tmp[0]);
            int p = Integer.parseInt(tmp[1]);

            if(t+i<=N+1){
                dp[i+t]=Math.max(dp[i]+p, dp[i+t]);
            }
            dp[i+1]=Math.max(dp[i+1],dp[i]);

        }
        System.out.println(dp[N]);

    }
}