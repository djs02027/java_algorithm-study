import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int [][] tsp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        StringTokenizer st;
        tsp= new int [n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                tsp[i][j]=Integer.parseInt(st.nextToken());
                j++;
            }
        }
        long [][] dp = new long [n][(1<<n)-1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        System.out.println(TSP(dp, 0,1));

    }
    private static long TSP(long [][] dp, int city, int bit){
        if(bit==((1<<n)-1)){ // 1을 왼쪽으로 1비트씩 5번이동  ex) 1 << 4 = 10000(2) = 16 -> 우리의 최대값 : 1111(2) 이므로 1 빼기
            if(tsp[city][0]==0){
                return Integer.MAX_VALUE;
            }
            return tsp[city][0];

        }
        if(dp[city][bit]!=Integer.MAX_VALUE){
            return dp[city][bit];
        }
        for (int i = 0; i < n; i++) { // 현재 도시(city)에서 각 i의 도시로 이동한 경우에 대해 DFS 수행
            if((bit & (1<<i))==0 && tsp[city][i]!=0){//다시 그 도시를 방문하는 경우 예외처리
                dp[city][bit]=Math.min(dp[city][bit],TSP(dp, i, bit|(1<<i))+tsp[city][i]);
            }
        }
        return dp[city][bit];
    }
}