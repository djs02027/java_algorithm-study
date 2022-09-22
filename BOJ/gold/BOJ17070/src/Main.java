import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N;
    static int count;
    static int[][] state;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        state = new int[N][N];
        int[][] visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                state[i][j] = Integer.parseInt(s[j]);
            }
        }
        DFS(0, 1, 0);
        System.out.println(count);


    }

    private static void DFS(int col, int row, int direction) {
        if (col == N - 1 && row == N - 1) {
            count++;
            return;
        }
        if (direction == 0) {

            if (row + 1 < N && state[col][row + 1] == 0) {
                DFS(col, row + 1, 0);
            }
            if (row + 1 < N && col + 1 < N && state[col + 1][row + 1] == 0 && state[col][row + 1] == 0 && state[col + 1][row] == 0) {
                DFS(col + 1, row + 1, 2);
            }


        } else if (direction == 1) {

            if (col + 1 < N && state[col + 1][row] == 0) {
                DFS(col + 1, row, 1);
            }
            if (row + 1 < N && col + 1 < N && state[col + 1][row + 1] == 0 && state[col][row + 1] == 0 && state[col + 1][row] == 0) {
                DFS(col + 1, row + 1, 2);
            }

        } else if (direction == 2) {
            if (row + 1 < N && state[col][row + 1] == 0) {
                DFS(col, row + 1, 0);
            }
            if (col + 1 < N && state[col + 1][row] == 0) {
                DFS(col + 1, row, 1);
            }
            if (row + 1 < N && col + 1 < N && state[col + 1][row + 1] == 0 && state[col][row + 1] == 0 && state[col + 1][row] == 0) {
                DFS(col + 1, row + 1, 2);
            }

        }
    }
}

