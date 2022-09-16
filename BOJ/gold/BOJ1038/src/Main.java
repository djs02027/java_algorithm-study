import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> result = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 0 1 2 3 4 5 6 7 8 9
        // 10 20 21 30 31 32 40 41 42 ...

        if (N < 10) {
            System.out.println(N);
        } else {
            for (int i = 0; i < 10; i++) {
                combi((long) i);
            }
            Collections.sort(result);

            if (result.size() <= N) {
                System.out.println(-1);
            } else {
                System.out.println(result.get(N));
            }
        }


    }

    public static void combi(long num) {
        if (num > Long.parseLong("9876543210")) {
            return;
        }
        result.add(num);
        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                combi((num * 10) + (long) i);
            }
        }
    }
}