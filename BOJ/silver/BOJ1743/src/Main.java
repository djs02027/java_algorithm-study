import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dc = {0, 0, 1, -1};
    static int[] dr = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        int MAX_Trash = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            map[c - 1][r - 1] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int c= BFS(i, j,1);
                    MAX_Trash=Math.max(MAX_Trash,c);
                }
            }
        }
        System.out.println(MAX_Trash);

    }

    private static int  BFS(int col, int row, int count) {

        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{col, row});
        visited[col][row] = 1;
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int nc = now[0];
            int nr = now[1];
            for (int i = 0; i < 4; i++) {
                int cc = dc[i] + nc;
                int cr = dr[i] + nr;
                if (0 <= cc && cc < N && 0 <= cr && cr < M) {
                    if (map[cc][cr] == 1 && visited[cc][cr]==0) {
                        count++;
                        visited[cc][cr]=1;
                        dq.offer(new int[]{cc, cr});
                    }
                }
            }
        }
        return count;

    }
}