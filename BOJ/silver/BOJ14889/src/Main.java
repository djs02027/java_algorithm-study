import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int minv = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] Link = new int[N][N];
        int[] Team = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                Link[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        FindTeam(Link, Team, N, 0, 0);
        System.out.println(minv);


    }

    private static void FindTeam(int[][] link, int[] team, int n, int r, int idx) {
        if (r == n / 2) {
            FindIndex(team, link);
            return;
        }
        for (int i = idx; i < n; i++) {
            if (team[i] == 0) {
                team[i] = 1;
                FindTeam(link, team, n, r + 1, i + 1);
                team[i] = 0;
            }


        }
    }

    private static void FindIndex(int[] team, int[][] link) {
        int teamA = 0;
        int teamB = 0;
        for (int i = 0; i < team.length; i++) {
            for (int j = i + 1; j < team.length; j++) {
                if (team[i] == 1 && team[j] == 1) {
                    teamA += (link[i][j] + link[j][i]);

                } else if (team[i] == 0 && team[j] == 0) {
                    teamB += (link[i][j] + link[j][i]);
                }
            }

        }
        int cac=Math.abs(teamA - teamB);
        minv=Math.min(minv,cac);
    }


}