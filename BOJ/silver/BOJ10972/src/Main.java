import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        int i = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            num[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        if(perm()){
            for (int j = 0; j < num.length; j++) {
                System.out.print(num[j]+" ");
            }
        }else {
            System.out.println(-1);
        }
    }

    private static boolean perm() {
        //먼저 배열의 뒤 부터 두개씩 비교하여 뒷부분의 숫자가 더 큰 경우가 있는 인덱스를 찾는다.
        //없는 경우 -1를 출력하고 종료한다.
        int i = N-1;
        while (i >0 && num[i-1] >= num[i]) i--;
        if(i==0){
            return false;
        }
        //i-1를 이후로 경계로 두어 배열의 뒤에서 부터 i-1과 비교하여 i-1보다 큰 값을 찾는다.
        //예 3 4 | 1 2 5 로 나뉘고 뒤부터 앞의 경계값인 2와 비교한다.
        int j = N-1;
        while ( num[i - 1] >= num[j]) j--;

        //i-1자리와 j를 스왑하여 위치 바꾼다.
        //예 3 4 1 5 2
        int tmp = num[i-1];
        num[i-1]=num[j];
        num[j]=tmp;

        //i-1 자리 이후 정렬이 필요한 경우
        //i-1 이후  i~N-1 자리까지 오름 차순으로 정렬 한다.
        j=N-1;
        while (i<j){
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}