import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] volume;
    static int maxv = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        volume = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int c = 1;
        while (st.hasMoreTokens()) {
            volume[c] = Integer.parseInt(st.nextToken());
            c++;
        }
        int[][] dp = new int[N + 1][M + 1];
        dp[0][S]=1;
        for (int i = 1; i < N+1; i++) {
            for(int j=0; j<M+1;j++){
                if(dp[i-1][j]==1){
                    if(j+volume[i]<=M){
                        dp[i][j+volume[i]]=1;
                    }
                    if(j-volume[i]>=0){
                        dp[i][j-volume[i]]=1;
                    }
                }

            }

        }
        for(int i=0; i<M+1;i++){
            if(dp[N][i]==1){
                maxv = Math.max(maxv, i);

            }
        }

        System.out.println(maxv);

    }



}