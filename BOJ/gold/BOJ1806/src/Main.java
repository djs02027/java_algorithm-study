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
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        while (st2.hasMoreTokens()) {
            numbers.add(Integer.valueOf(st2.nextToken()));
        }
        int Lp = 0;
        int Rp = 0;
        int minv = (int) 1e9;
        int total = numbers.get(0);

        while (true) {
            if (Lp > Rp) {
                break;
            }
            if (total < S) {
                Rp += 1;
                if (Rp >= N) {
                    break;

                }
                total += numbers.get(Rp);
            } else {
                minv=Integer.min(minv,Rp-Lp+1);
                total-=numbers.get(Lp);
                Lp += 1;
                if (Lp>=N){
                    break;
                }
            }

        }
        if(minv==(int) 1e9){
            System.out.println(0);
        }
        else {
            System.out.println(minv);
        }

    }
}