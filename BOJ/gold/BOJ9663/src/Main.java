import java.util.Scanner;

public class Main {
    static int[] dc = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1};
    static int N;
    static int[] chess;
    static int totalCount=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chess = new int[N];

        QueenPlace(0);
        System.out.println(totalCount);

    }

    private static void QueenPlace(int depth) {
        if (depth == N) {
            totalCount++;
            return;
        }
        for (int i = 0; i < N; i++) {
            chess[depth]=i;
            if(checkPlace(depth)){
                QueenPlace(depth+1);
            }
        }
    }
    private static boolean checkPlace(int col) {
        for(int i=0;i<col;i++){
            if(chess[i]==chess[col]){
                return false;
            } else if (Math.abs(col-i)==Math.abs(chess[col]-chess[i])) {
                return false;
            }
        }
        return true;
    }


}