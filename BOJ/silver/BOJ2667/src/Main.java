import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] MAP = new ArrayList[n];
        int [][] vistied = new int[n][n];
        for (int i = 0; i < n; i++) {
            MAP[i] = new ArrayList<>();
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            for (int j = 0; j < input.length(); j++) {
                MAP[i].add(Integer.parseInt(String.valueOf(input.charAt(j))));
            }
        }
        int MapCnt=0;
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                if(MAP[i].get(j)==1){
                    if (vistied[i][j]==0){
                        vistied[i][j]=1;
                        int count=Find(MAP,vistied,i,j,n,1);
                        MapCnt+=1;
                        System.out.println(count);
                    }

                }
            }
        }

    }

    public static int Find(ArrayList<Integer>[] MAP,int[][] vistied, int i, int j, int n, int count) {
        int [] dc={0,0,-1,1};
        int [] dr={1,-1,0,0};
        for(int k=0;k<4;k++){
            int nc=i+dc[k];
            int nr=j+dr[k];
            if((0<=nc&&nc<n)&&(0<=nr&&nr<n)){
                if (MAP[nc].get(nr)==1){
                    if(vistied[nc][nr]==0){
                        vistied[nc][nr]=1;
                        count+=1;
                        Find(MAP,vistied,nc,nr,n,count);
                        vistied[nc][nr]=0;
                    }

                }
            }

        }
        return count;

    }
}