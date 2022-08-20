import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int add;
    static int sub;
    static int mul;
    static int div;
    static int minV = (int) (1e9);
    static int maxV = -(int) (1e9);


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int i = 0;
        while (st1.hasMoreTokens()) {
            numbers[i] = Integer.parseInt(st1.nextToken());
            i++;
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st2.nextToken());
        sub = Integer.parseInt(st2.nextToken());
        mul = Integer.parseInt(st2.nextToken());
        div = Integer.parseInt(st2.nextToken());

        int total = numbers[0];
        DFS(numbers, total, 1);

        System.out.println(maxV);
        System.out.println(minV);

    }

    private static void DFS(int[] numbers, int total, int index) {
        if (index == numbers.length) {
            minV=Integer.min(minV,total);
            maxV=Integer.max(maxV,total);
            return;
        }
        if (add > 0) {
            add -= 1;
            DFS(numbers, total + numbers[index], index + 1);
            add += 1;

        }
        if (sub > 0) {
            sub -= 1;
            DFS(numbers, total - numbers[index], index + 1);
            sub += 1;

        }
        if (mul > 0) {
            mul -= 1;
            DFS(numbers, total * numbers[index], index + 1);
            mul += 1;

        }
        if (div > 0) {
            div -= 1;
            DFS(numbers, total / numbers[index], (index + 1));
            div += 1;

        }
    }


}