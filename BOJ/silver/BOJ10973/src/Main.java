import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            num[idx] += Integer.parseInt(st.nextToken());
            idx++;
        }
        // 5 4 3 2 1
        //0
        //
        if (perm()) {
            for (int i = 0; i < N; i++) {
                System.out.println(num[i]+" ");
            }
        }else {
            System.out.println(-1);
        }


    }

    private static boolean perm() {

        //먼저 배열의 뒤 부터 두개씩 비교하여 앞부분의 숫자가 더 큰 경우가 있는 인덱스를 찾는다.
        //없는 경우 -1를 출력하고 종료한다.
        int i = N - 1;
        while (i > 0 && num[i - 1] <= num[i]) i--;
        if (i <= 0) return false;

        //i-1를 이후로 경계로 두어 배열의 뒤에서 부터 i-1과 비교하여 i-1보다 작은 값을 찾는다.
        //예 3 4 | 1 2 5 로 나뉘고 뒤부터 앞의 경계값인 4와 바교한다.
        int j = N - 1;
        while (j > 0 && num[i - 1] <= num[j]) j--;

        //i-1자리와 j를 스왑하여 위치 바꾼다.
        //예 3 2 1 2 5
        int tmp = num[i - 1];
        num[i - 1] = num[j];
        num[j] = tmp;

        //i-1 이후  i~N-1 자리까지 내림 차순으로 정렬 한다.
        // 3 2 | 1 4 5 => 3 2 5 4 1
        j = N - 1;
        while (i < j) {
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i += 1;
            j -= 1;
        }


        return true;
    }


}