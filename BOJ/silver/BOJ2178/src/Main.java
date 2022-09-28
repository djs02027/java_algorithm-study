import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int[][] visited;
    static int N;
    static int M;
    static int[] dc = {0, 0, 1, -1};
    static int[] dr = {-1, 1, 0, 0};
    static int minValue = (int) 1e9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        visited = new int[N][M];
        visited[0][0] = 1;
//        시간초과
//        DFS(0, 0, 1, miro);
//        System.out.println(minValue);

        BFS(0,0,miro);
        System.out.println(visited[N-1][M-1]);
    }

    private static void BFS(int col, int row, int[][] miro) {

        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{col, row});
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int nc = now[0];
            int nr = now[1];
            for (int i = 0; i < 4; i++) {
                int cc = dc[i] + nc;
                int cr = dr[i] + nr;
                if (0 <= cc && cc < N && 0 <= cr && cr < M && visited[cc][cr] == 0) {
                    if (miro[cc][cr] == 1) {
                        dq.offer(new int[]{cc, cr});
                        visited[cc][cr] = visited[nc][nr] + 1;

                    }
                }

            }


        }
    }

    private static void DFS(int col, int row, int count, int[][] miro) {
        if (col == N - 1 && row == M - 1) {
            minValue = Math.min(minValue, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cc = dc[i] + col;
            int cr = dr[i] + row;
            if (0 <= cc && cc < N && 0 <= cr && cr < M && visited[cc][cr] == 0) {
                if (miro[cc][cr] == 1) {
                    visited[cc][cr] = 1;
                    DFS(cc, cr, count+1, miro);
                    visited[cc][cr]  = 0;


                }
            }
        }


    }
}