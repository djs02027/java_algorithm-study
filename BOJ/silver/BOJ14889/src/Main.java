import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] team = new int [n][n];
        StringTokenizer st ;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                team[i][j]=Integer.parseInt(st.nextToken());
                j++;
            }
        }
        boolean [] visited = new boolean [n];
        teamMatch(team,visited, n,0,0);
        System.out.println(answer);

        

    }

    private static void teamMatch(int[][] team, boolean[] visited, int n, int r, int idx) {
        if(r==n/2){
            teamAnalysis(team, visited);
            return;
        }
        for (int i = idx; i < n; i++) {
            if(!visited[i]){
                visited[i]=true;
                teamMatch(team, visited, n, r+1,i+1);
                visited[i]=false;
            }
        }
    }

    private static void teamAnalysis(int[][] team, boolean[] visited) {
        int TeamA=0;
        int TeamB=0;
        for (int i = 0; i < team.length; i++) {
            for (int j = i+1; j < team[i].length; j++) {

                if(visited[i]== true && visited[j]==true){
                    TeamA+=(team[i][j]+team[j][i]);
                } else if (visited[i]==false && visited[j]== false) {
                    TeamB+=(team[i][j]+team[j][i]);
                }

            }
        }
        answer=Math.min(answer,Math.abs(TeamA-TeamB));
    }


}