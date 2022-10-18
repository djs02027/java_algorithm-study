import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[21][N];
        dp[num[0]][0] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[j][i - 1] != 0) {
                    int tmp1 = j - num[i];
                    if (tmp1 >= 0) {
                        dp[tmp1][i] += (dp[j][i - 1]);
                    }
                    int tmp2 = j + num[i];
                    if (tmp2 <= 20) {
                        dp[tmp2][i] += (dp[j][i - 1]);
                    }
                }

            }

        }
        System.out.println(dp[num[N-1]][N-2]);

    }
}