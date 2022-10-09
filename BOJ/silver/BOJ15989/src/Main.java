import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int [] caseNum = new int [t];
        for(int i =0; i<t;i++){
            int n=sc.nextInt();
            caseNum[i]=n;
        }
        int [] dp = new int[10001];
        Arrays.fill(dp,1);
        for(int i=2; i<10001; i++){
            dp[i]=dp[i]+dp[i-2];
        }
        for(int i=3; i<10001; i++){
            dp[i]=dp[i]+dp[i-3];
        }
        for(int i=0; i<caseNum.length;i++){
            System.out.println(dp[caseNum[i]]);
        }



    }
}