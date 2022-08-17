import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int i = 0;
        while (st.hasMoreTokens()) {
            numbers[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        int[] numberList = new int[1001];
        Arrays.fill(numberList, 0);
        for (int j = 2; j <= 1000; j++) {
            int flag = 0;
            for (int k = 2; k < j; k++) {
                if (j % k == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                numberList[j] = 1;
            }

        }

        int total = 0;
        for (int n = 0; n < numbers.length; n++) {
            if (numberList[numbers[n]] == 1) {
                total += 1;
            }
        }
        System.out.println(total);

    }
}