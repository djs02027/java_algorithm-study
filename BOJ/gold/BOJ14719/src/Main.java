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
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int [] field =new int[W];
        int i=0;
        while (st2.hasMoreTokens()) {
            field[i]=Integer.valueOf(st2.nextToken());
            i++;

        }
        int total = 0;
        int Left = 0;
        int Right = (W - 1);
        int Lmax = field[Left];
        int Rmax = field[Right];

        while (Left < Right) {

            Lmax = Integer.max(Lmax,field[Left]);
            Rmax = Integer.max(Rmax,field[Right]);
            if (Lmax<Rmax){
                total+=Lmax-field[Left];
                Left+=1;

            }
            if (Lmax>=Rmax){
                total+=Rmax-field[Right];
                Right-=1;
            }



        }
        System.out.println(total);


    }
}