import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= i; j++) {
                numbers.add(i);

            }

        }
        int total=0;
        for(int i=A-1; i<=B-1; i++){
            total+= numbers.get(i);
        }
        System.out.println(total);

    }
}