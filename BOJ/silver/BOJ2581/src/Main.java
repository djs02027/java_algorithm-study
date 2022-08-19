import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int minV= (int) 1e9;
        int total=0;

        for (int i=M;i<=N;i++){
            int flag=0;
            for(int j=2; j<i;j++){
                if (i%j==0){
                    flag=1;
                    break;

                }
            }
            if (flag==0 && i>1){
                minV=Integer.min(minV, i);
                total+=i;
            }

        }
        if (total==0 && minV==(int)1e9){
            System.out.println(-1);
        }else {
            System.out.println(total);
            System.out.println(minV);
        }



    }
}