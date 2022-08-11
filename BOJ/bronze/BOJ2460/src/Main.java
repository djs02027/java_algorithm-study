
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int total=0;
        int high=-1;
        for (int i=0; i<10; i++){
            int N= scanner.nextInt();
            int M= scanner.nextInt();
            total-=N;
            total+=M;
            high=Integer.max(total,high);
        }
        System.out.println(high);
    }
}