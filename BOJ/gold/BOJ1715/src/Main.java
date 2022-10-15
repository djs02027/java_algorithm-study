import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cards = new int[N];
        PriorityQueue<Long> dq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            dq.offer(sc.nextLong());
        }

        long num = 0;
        while (dq.size() > 1) {
            long tmp1 = dq.poll();
            long tmp2 = dq.poll();
            num += tmp1 + tmp2;
            dq.offer(tmp1 + tmp2);
        }
        System.out.println(num);

    }

}