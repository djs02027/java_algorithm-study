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
        //E와 S의 최대공약수를 구한다.
        int gcdTmp=GCD(E_MAX,S_MAX);
        //E와 S의 최소공배수를구한다.
        int lcmTmp=(E_MAX*S_MAX)/gcdTmp;
        //구한 최대공약수와 M의 최대공약수를 구한다.
        int gcd=GCD(lcmTmp,M_MAX);
        //구한 최소공배수와 M의 최소공배수를 구한다.
        int lcd=(lcmTmp*M_MAX)/gcd;


        int cacYear=E;
        while (cacYear<=lcd){
            if((cacYear-S)%S_MAX==0 &&(cacYear-M)%M_MAX==0 ){
                break;
            }
            cacYear+=E_MAX;
        }
        System.out.println(cacYear);









    }


    private static int GCD(int a, int b) {
        int now= a%b;
        if(now==0){
            return b;
        }else{
            return GCD(b,now);
        }
    }

}