import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class Main {
    static int count=0;
    static int [][] vistied ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] MAP = new ArrayList[n];
        vistied = new int[n][n];
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
        Deque<Integer> answer= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                if(MAP[i].get(j)==1){
                    if (vistied[i][j]==0){
                        vistied[i][j]=1;
                        count= 1;
                        Find(MAP,i,j,n);
                        MapCnt+=1;
                        answer.offer(count);
                    }

                }
            }
        }
        int [] result = new int [MapCnt];
        System.out.println(MapCnt);
        int k=0;
        while (!(answer.isEmpty())){
            result[k]= answer.pollFirst();
            k++;
        }
        Arrays.sort(result);
        for (int re:
             result) {
            System.out.println(re);
        }

    }

    static void Find(ArrayList<Integer>[] MAP, int i, int j, int n ) {
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
                        Find(MAP,nc,nr,n);

                    }

                }
            }

        }


    }
}