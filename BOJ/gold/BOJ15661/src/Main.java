import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] table;
    static int Minv =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N= Integer.parseInt(br.readLine());
        table = new int[N][N];
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                table[i][j]=Integer.parseInt(st.nextToken());
                j++;
            }
        }
        int [] team =new int [N];
        FindTeam(team,0,0);
        System.out.println(Minv);
    }

    private static void FindTeam(int[] team, int idx, int r) {
        if(r>0 && r<N){
            FindDiff(team);
        }


        for (int i = idx; i < N; i++) {
                team[i]=1;
                FindTeam(team,i+1 ,r+1);
                team[i]=0;
        }


    }

    private static void FindDiff(int[] team) {
        int teamA=0;
        int teamB=0;
        for (int i = 0; i < team.length; i++) {
            for (int j = i+1; j < team.length; j++) {
                if(team[i]==1 && team[j]==1){
                    teamA+=(table[i][j]+table[j][i]);
                } else if (team[i]==0&&team[j]==0) {
                    teamB+=(table[i][j]+table[j][i]);

                }
            }
        }
        int cac= Math.abs(teamA-teamB);
        Minv=Math.min(Minv,cac);
    }
}