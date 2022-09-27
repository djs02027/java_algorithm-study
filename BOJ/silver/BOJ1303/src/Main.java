import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] visitied;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, 1, -1};
    static char[][] field;
    static int count=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new char[M][N];
        visitied = new int[M][N];
        int White=0;
        int Bule=0;
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                field[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visitied[i][j] == 0) {
                    visitied[i][j] = 1;
                    count = 1;
                    DFS(i, j, field[i][j]);

                    if(field[i][j]=='W'){
                        White+=Math.pow(count,2);
                    }else{
                        Bule+=Math.pow(count,2);
                    }

                }
            }
        }
        System.out.println(White+" "+Bule);

    }



    private static void DFS(int col, int row, char pattern) {
        for (int i = 0; i < 4; i++) {
            int cc = col + dc[i];
            int cr = row + dr[i];
            if (0 <= cc && cc < M && 0 <= cr && cr < N) {
                if (visitied[cc][cr] == 0 && field[cc][cr] == pattern){
                    visitied[cc][cr] = 1;
                    count++;
                    DFS(cc, cr,  pattern);
                }


            }

        }



    }
}