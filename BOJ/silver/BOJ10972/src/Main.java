import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());
        int [] number = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int j=0;
        while (st.hasMoreTokens()){
            number[j]=Integer.parseInt(st.nextToken());
            j++;
        }
        if(NextPerm(number, N)){
            for (int i = 0; i < number.length; i++) {
                System.out.print(number[i]+" ");
            }
        }else {
            System.out.println(-1);
        }


    }

    private static boolean NextPerm(int[] number, int n) {
        int i = n-1;
        //뒤에서 부터 오름차순이 끊긴 지점을 찾는다.
        while (i>0 && number[i-1]>=number[i]) i--;
        if(i==0){
            return false;
        }
        int j=n-1;
        // 끊긴 지점의 뒷 수보다 큰 수를 뒤에서 부터 찾는다.
        while (number[i-1]>=number[j]) j--;
        int tmp = number[i-1];
        number[i-1]= number[j];
        number[j]=tmp;

        //끊긴지점 앞부분들의 수를 오름차순으로 정렬을 해준다.
        j=n-1;
        while (i<j){
            tmp=number[i];
            number[i]=number[j];
            number[j]=tmp;
            i+=1;
            j-=1;

        }
        return true;





    }


}