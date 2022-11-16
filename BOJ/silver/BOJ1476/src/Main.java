import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int E_MAX = 15;
        int S_MAX = 28;
        int M_MAX = 19;
        int year=e;
        while (true){
            if((year-s)%S_MAX ==0 && (year-m)%M_MAX==0){
                break;
            }
                year+=E_MAX;
        }
        System.out.println(year);

    }

}