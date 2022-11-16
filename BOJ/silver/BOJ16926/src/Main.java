import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                table[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        int rotation_cnt = Math.min(m, n) / 2;

        for (int i = 0; i < r; i++) {

            rotaion(m,n,rotation_cnt,table);
        }
        StringBuilder sb =new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                sb.append(table[i][j]).append(" ");
            }
            if(i<table.length-1){
                sb.append('\n');
            }

        }
        System.out.println(sb);


    }
    private static void rotaion(int m, int n, int rotation_cnt, int[][] table){
        for (int i = 0; i < rotation_cnt; i++) {
            int start_col=i;
            int start_row=i;
            int end_col=m-1-i;
            int end_row=n-1-i;
            
            int start = table[start_col][start_row];
            //위쪽
            for (int j = i; j <end_row ; j++) {
                table[start_col][j]=table[start_col][j+1];
                
            }
            //오른쪽
            for (int j = i; j <end_col ; j++) {
                table[j][end_row]=table[j+1][end_row];
            }
            //아랫쪽
            for (int j = end_row; j >start_row ; j--) {
                table[end_col][j]=table[end_col][j-1];
            }
            //왼쪽
            for (int j = end_col; j >start_col ; j--) {
                table[j][start_row]=table[j-1][start_row];
            }
            table[start_col+1][start_row]=start;
            
        }
    }
}