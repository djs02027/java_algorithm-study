import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int minV= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        BFSFindSUM(N, K);
        if (minV==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(minV);
        }


    }

    private static void BFSFindSUM(Long n, Long k) {
        Deque<long[]> dq = new LinkedList<>();
        dq.offer(new long[]{n, 1});
        while (!dq.isEmpty()) {
            long [] now = dq.pollFirst();
            long value = now[0];
            long count = now[1];
            if (value==k){
                minV= (int) Math.min(minV,count);
            }
            if (value <= k) {
                dq.offer(new long[]{value * 2, count + 1});
                dq.offer(new long[]{Long.valueOf(String.valueOf(value) +"1"), count + 1});
            }


        }

    }
}