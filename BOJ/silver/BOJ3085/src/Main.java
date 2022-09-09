import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        ArrayList<String>[] board = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = new ArrayList<>();

            while (st.hasMoreTokens()) {
                board[i].add(st.nextToken());

            }
        }
        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int cc = 0;
                int cr = 0;
                for (int k = 0; k < 4; k++) {
                    cc = i + dc[k];
                    cr = j + dr[k];

                    if ((0 <= cc && cc < board.length) && (0 <= cr && cr < board.length)) {
                        if (!(board[cc].get(cr).equals(board[i].get(j)))) {
                            String tmp = board[cc].get(cr);
                            String Nowtmp = board[i].get(j);
                            board[i].set(j, tmp);
                            total = CountCandy(board);
                            board[i].set(j, Nowtmp);

                        }

                    }

                }
            }

            System.out.println(total);

        }


    }

    public static int CountCandy(ArrayList<String>[] board) {

        int maxRow = -(int) 1e9;
        int maxCol = -(int) 1e9;
        int totalMax;
        for (int i = 0; i < N; i++) {
            int rowCnt = 1;
            int colCnt = 1;
            for (int j = 0; j < board[i].size() - 1; j++) {
                if (board[i].get(j).equals( board[i].get(j + 1))) {
                    rowCnt += 1;
                } else {
                    rowCnt = 1;
                }
                if (board[j + 1].get(i).equals( board[j].get(i))) {
                    colCnt += 1;
                } else {
                    colCnt = 1;
                }

                maxRow = Integer.max(maxRow, rowCnt);
                maxCol = Integer.max(maxCol, colCnt);


            }


        }
        totalMax = Integer.max(maxRow, maxCol);
        return totalMax;
    }
}

