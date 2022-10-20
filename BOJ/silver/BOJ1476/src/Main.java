import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int E=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int E_MAX=15;
        int S_MAX=28;
        int M_MAX=19;


        int cacYear=E;
        while (true){
            if((cacYear-S)%S_MAX==0 &&(cacYear-M)%M_MAX==0 ){
                break;
            }
            cacYear+=E_MAX;
        }
        System.out.println(cacYear);


    }

}