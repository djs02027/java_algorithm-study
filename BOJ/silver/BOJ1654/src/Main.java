import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int K=sc.nextInt();
        long N=sc.nextInt();
        long [] len = new long [K];
        for (int i = 0; i <K; i++) {
            len[i]= sc.nextInt();
        }
        Arrays.sort(len);
        long left=1;
        long right=len[len.length-1];
        long total=0;
        while (left<=right){
            long mid = (left+right)/2;
            long cuttting =0;
            for (int i = 0; i < len.length; i++) {
                cuttting+=len[i]/mid;
            }
            if(cuttting<N){
                right=mid-1;
            }else{
                total=Math.max(total,mid);
                left=mid+1;
            }

        }
        System.out.println(total);





    }
}