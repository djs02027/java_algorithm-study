import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int S;
    static int[] num;


    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            num[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        DFS(0, 0);
        if(S==0){
            System.out.println(count-1);
        }else{
            System.out.println(count);
        }



    }

    private static void DFS(int sum, int r) {

        if (N == r) {
            if (sum == S) {
                count++;
            }
            return;
        }

        DFS(sum + num[r], r + 1) ;
        DFS(sum , r + 1) ;

    }
}