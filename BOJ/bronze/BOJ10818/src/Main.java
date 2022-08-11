import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int [] numbers= new int[N];
        for (int i=0; i<N;i++){
            numbers[i]=scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(numbers);
        System.out.print(numbers[0]+" "+ numbers[N-1]);


    }
}