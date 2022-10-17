import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][] tmp = new int[T][4];
        for (int i = 0; i < T; i++) {
            st=new StringTokenizer(br.readLine());
            tmp[i][0]= Integer.parseInt(st.nextToken());
            tmp[i][1]= Integer.parseInt(st.nextToken());
            tmp[i][2]= Integer.parseInt(st.nextToken());
            tmp[i][3]= Integer.parseInt(st.nextToken());

        }
        for (int i = 0; i < T; i++) {
            long result = findYear(tmp[i][0],tmp[i][1],tmp[i][2],tmp[i][3]);
            System.out.println(result);
        }

    }

    private static long findYear(int m, int n, int x, int y) {
        long count=y;

        while (count<=m*n) {
            if((count-x)%m==0 && (count-y)%n==0){
                return count;
            }
            count+=n;

        }
        return -1;


    }
}