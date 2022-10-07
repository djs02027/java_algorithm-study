import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];
        long[][] answer = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        answer[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i == N - 1 && j == N - 1) {
                    continue;
                }
                if (answer[i][j] == 0) {
                    continue;
                }
                int now = arr[i][j];
                if (i + now < N) {
                    answer[i + now][j] += answer[i][j];
                }
                if (j + now < N) {
                    answer[i][j + now] += answer[i][j];
                }
            }
        }
        System.out.println(answer[N - 1][N - 1]);


    }


}