import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int N;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] state = new int[N][N];
        int[][] visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                state[i][j] = Integer.parseInt(s[j]);
            }
        }
        DFS(0,1,0);



    }

    private static void DFS(int col, int row, int direction) {
        if (col==N-1 && col==N-1){
            count++;
            return;
        }
        if (direction==0){
            if (row==N-1){
                return;
            }


        }
        else if (direction==1){

        }
        else if (direction==2){

        }
    }
}

