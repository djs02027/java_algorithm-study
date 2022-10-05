import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dc = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] field;
    static int N;
    static int M;
    static int maxValue = -(int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0) {
                    maxValue=Math.max(maxValue, BFS(i, j, 0));

                }

            }

        }
        System.out.println(maxValue);



    }

    private static int BFS(int i, int j, int dist) {
        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{i, j, dist});
        int[][] visited = new int[N][M];
        visited[i][j] = 1;
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int nc = now[0];
            int nr = now[1];
            int ndist = now[2];
            for (int x = 0; x < 8; x++) {
                int cc = nc + dc[x];
                int cr = nr + dr[x];
                if (0 <= cc && cc < N && 0 <= cr && cr < M) {
                    if (visited[cc][cr] == 0 && field[cc][cr] == 0) {
                        visited[cc][cr] = 1;
                        dq.offer(new int[]{cc, cr, ndist + 1});
                    } else if (visited[cc][cr] == 0 && field[cc][cr] == 1) {
                        return ndist+1;
                    }
                }

            }
        }


        return -1;
    }
}