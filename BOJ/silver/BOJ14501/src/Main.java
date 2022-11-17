import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] period = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            period[i] = t;
            cost[i] = p;
        }
        int [] dp = new int[n+2];
        for (int i = 0; i < n; i++) {
            if(period[i]+i<=n+1){
                dp[period[i]+i]=Math.max(dp[period[i]+i], dp[i]+cost[i]);

            }
            dp[i+1]=Math.max(dp[i],dp[i+1]);
        }
        System.out.println(dp[n]);





    }
}