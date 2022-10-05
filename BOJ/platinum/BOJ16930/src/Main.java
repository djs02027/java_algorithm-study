import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int M;
    static String[][] field;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int MinTime = (int) 1e9;
    static int[][] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        field = new String[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = String.valueOf(s.charAt(j));
                visited[i][j]=Integer.MAX_VALUE;

            }
        }
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        BFS(x1, y1, x2, y2);
        if(MinTime==(int)1e9){
            System.out.println(-1);
        }else{
            System.out.println(MinTime);
        }

    }

    private static void BFS(int x1, int y1, int x2, int y2) {
        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{x1, y1, 0});

        visited[x1][y1] = 0;
        while (!(dq.isEmpty())) {
            int[] now = dq.pollFirst();
            int col = now[0];
            int row = now[1];
            int time = now[2];
            if (col == x2 && row == y2) {
                MinTime = Math.min(MinTime, time);
                break;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    int cc = (dc[i] * j) + col;
                    int cr = (dr[i] * j) + row;
                    if (0 > cc || cc >= N || 0 > cr || cr >= M) {
                        break;
                    }
                    if (field[cc][cr].equals("#") || visited[cc][cr]<visited[col][row]+1) {
                        break;
                    } else if (field[cc][cr].equals(".") && visited[cc][cr] == Integer.MAX_VALUE) {
                        dq.offer(new int[]{cc, cr, time + 1});
                        visited[cc][cr] = time+1;
                    }
                }


            }

        }


    }
}