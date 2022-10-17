import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] WeightList = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            WeightList[i][0] = W;
            WeightList[i][1] = V;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - WeightList[i][0] >= 0) {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-WeightList[i][0]]+WeightList[i][1]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);


    }
}