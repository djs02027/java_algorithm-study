import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                numbers.add(i);
            }

        }
        try{
            System.out.println(numbers.get(K-1));
        } catch (Exception e) {
            System.out.println(0);
        }


    }
}