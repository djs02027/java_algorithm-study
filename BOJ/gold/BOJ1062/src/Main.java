import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static String[] words;
    static int[] alpa;
    static int total = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        words = new String[N];
        alpa = new int[26];
        alpa['a' - 97] = 1;
        alpa['n' - 97] = 1;
        alpa['t' - 97] = 1;
        alpa['i' - 97] = 1;
        alpa['c' - 97] = 1;
        int alpaCnt = K - 5;
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        if (K < 5) {
            System.out.println(0);
        } else {
            countFind(0,0, alpaCnt);
            System.out.println(total);
        }

    }

    private static void countFind(int index, int depth, int alpaCnt) {

        if (depth == alpaCnt) {
            int matchCount = 0;
            for (int i = 0; i < words.length; i++) {
                char[] charr = words[i].toCharArray();
                int flag=0;
                for(char ch :charr){
                    if (alpa[ch-97]==0){
                        flag=1;
                        break;
                    }
                }
                if (flag == 0) {
                    matchCount += 1;
                    total = Math.max(total, matchCount);
                }
            }
            return;
        }
        for (int i = index; i < alpa.length; i++) {
            if (alpa[i] == 0) {
                alpa[i] = 1;
                countFind(i, depth + 1, alpaCnt);
                alpa[i] = 0;

            }
        }


    }


}