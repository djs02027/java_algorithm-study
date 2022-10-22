import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int maxV=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        String [] tmp= br.readLine().split(" ");
        int [] num = new  int[N];
        for (int i = 0; i < tmp.length; i++) {
            num[i]=Integer.parseInt(tmp[i]);
        }

        permutation( num, 0);
        System.out.println(maxV);

    }

    private static void permutation( int[] num, int r) {
        if(r==N){

            int total=0;
            for (int i = 1; i < num.length; i++) {
                int tmpA=num[i-1];
                int tmpB=num[i];
                int cac =Math.abs(tmpA-tmpB);
                total+=cac;
            }
            maxV=Math.max(maxV,total);
            return;
        }
        for (int i = 0; i < N; i++) {
                swap(num,r,i);
                permutation(num,r+1);
                swap(num,r,i);

        }
    }

    private static void swap(int[] num, int r, int i) {
        int tmp=num[i];
        num[i]=num[r];
        num[r]=tmp;
    }
}