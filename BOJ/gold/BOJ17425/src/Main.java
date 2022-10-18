import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[MAX];
        //1은 모든수의 약수이므로
        Arrays.fill(dp, 1);
        for (int i = 2; i < MAX; i++) {
            for (int j = 1; j * i < MAX; j++) {
                //i*j의 약수인 i를 더해준다.
                //4의 약수 2*2, 4*1 등 124가 더해짐
                dp[i * j] += i;
            }
            //누적합을 만들기 위해 진행
            dp[i] = dp[i] + dp[i - 1];
        }
        //sout보다는 stringbulider를 활용해야 시간 초과가 안남
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]+"\n");
        }
        System.out.println(sb);

    }
}