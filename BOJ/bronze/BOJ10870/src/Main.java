import java.util.Scanner;

public class Main {
    public static int fibo(int n){
        if (n>=2){
            return fibo(n-2)+fibo(n-1);
        }
        else {
            return n;
        }

    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int N= scanner.nextInt();
        System.out.println(fibo(N));
    }

}