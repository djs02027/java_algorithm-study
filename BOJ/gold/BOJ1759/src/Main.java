import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        count=0;
        String s= br.readLine();
        String [] alpa =s.split(" ");
        Arrays.sort(alpa);
        String [] visited = new String[N];
        FindPassword(alpa, visited,0, 0);



    }

    private static void FindPassword(String[] alpa,String [] visited, int r, int tmp) {
        if(r==N){
            int vowels =0;
            int consonants=0;
            String str= String.join("",visited);
            for (int i=0; i<visited.length;i++){
                if(visited[i].equals("a")||visited[i].equals("e")||visited[i].equals("i")||visited[i].equals("o")||visited[i].equals("u")){
                    vowels++;
                }else {
                    consonants++;
                }
            }
            if(vowels>=1 && consonants>=2 ){
                System.out.println(str);
            }

            return;
        }
        for (int i = tmp; i < L; i++) {
                visited[r]=alpa[i];
                FindPassword(alpa, visited, r+1,i+1);



        }
    }
}