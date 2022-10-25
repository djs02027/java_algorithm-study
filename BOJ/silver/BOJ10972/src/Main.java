import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        int i = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            num[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        if(perm()){
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[j]+" ");
            }
        }else {
            System.out.println(-1);
        }
    }

    private static boolean perm() {
        int i = N-1;
        while (i >0 && num[i-1] >= num[i]) i--;
        if(i==0){
            return false;
        }
        int j = N-1;
        while ( num[i - 1] >= num[j]) j--;

        int tmp = num[i-1];
        num[i-1]=num[j];
        num[j]=tmp;


        j=N-1;
        // 앞자리수가 바뀔때
        while (i<j){
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}