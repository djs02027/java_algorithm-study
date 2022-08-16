import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = Integer.min(N, M); i > 0; i--) {
            if (N % i == 0 && M % i == 0) {
                System.out.println(i);
                break;
            }
        }
        for (int i = Integer.max(N, M); i < N * M + 1; i++) {
            if (i % N == 0 && i % M == 0) {
                System.out.println(i);
                break;
            }
        }
    }

}
