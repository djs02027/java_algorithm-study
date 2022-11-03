import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String s = br.readLine();
            if(s.equals("0")){
                break;
            }
            String[] tmp = s.split(" ");
            int n= Integer.parseInt(tmp[0]);
            int [] num = new int[n];
            for (int i = 1; i < tmp.length; i++) {
                num[i-1]=Integer.parseInt(tmp[i]);
            }
            int [] lotto = new int [6];
            FindNumber(lotto,num,n,0 ,0 );
            System.out.println();



        }
    }

    private static void FindNumber(int [] lotto, int[] num, int n, int r, int idx) {
        if(r==6){
            for (int i = 0; i < lotto.length; i++) {
                System.out.print(lotto[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = idx; i <num.length ; i++) {
            lotto[r]=num[i];
            FindNumber(lotto,num,n,r+1,i+1);
        }
    }
}