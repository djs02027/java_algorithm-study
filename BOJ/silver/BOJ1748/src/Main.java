import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long N= sc.nextLong();
        long sum=0;
        long guide =10;
        long len=1;
        for (long i = 1; i <= N; i++) {
            if(i==guide){
                guide*=10;
                len+=1;
            }
            sum+=len;
        }
        System.out.println(sum);

    }
}