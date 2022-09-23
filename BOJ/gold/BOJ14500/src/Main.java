import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1};
    static int[][] paper;
    static int maxValue = -(int) 1e9;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                visited[i][j] = 1;
                findSum(i, j, 1, paper[i][j], visited);
                visited[i][j] = 0;
                findTsum(i, j);


            }
        }
        System.out.println(maxValue);

    }

    private static void findTsum(int col, int row) {
        int Tvalue = 0;
        if (0 <= col - 1 && 0 <= row - 1 && row + 1 < M) { //ㅗ
            Tvalue = paper[col - 1][row] + paper[col][row] + paper[col][row + 1] + paper[col][row - 1];
            maxValue = Math.max(maxValue, Tvalue);
        }
        if (col + 1 < N && 0 <= row - 1 && row + 1 < M) { // ㅜ
            Tvalue = paper[col + 1][row] + paper[col][row] + paper[col][row + 1] + paper[col][row - 1];
            maxValue = Math.max(maxValue, Tvalue);
        }
        if (0 <= col - 1 && col + 1 < N && row + 1 < M) { //ㅏ
            Tvalue = paper[col - 1][row] + paper[col][row] + paper[col][row + 1] + paper[col + 1][row];
            maxValue = Math.max(maxValue, Tvalue);
        }
        if (0 <= col - 1 && col + 1 < N && 0 <= row - 1) { //ㅓ
            Tvalue = paper[col - 1][row] + paper[col][row] + paper[col][row - 1] + paper[col + 1][row];
            maxValue = Math.max(maxValue, Tvalue);
        }

    }

    private static void findSum(int col, int row, int depth, int total, int[][] visited) {

        if (depth == 4) {
            maxValue = Math.max(maxValue, total);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cc = dc[i] + col;
            int cr = dr[i] + row;
            if (0 <= cc && cc < N && 0 <= cr && cr < M) {
                if (visited[cc][cr] == 0) {
                    visited[cc][cr] = 1;
                    findSum(cc, cr, depth + 1, total + paper[cc][cr], visited);
                    visited[cc][cr] = 0;

                }
            }

        }

    }
}
