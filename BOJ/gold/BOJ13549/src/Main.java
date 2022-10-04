import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int[] visited;
    static int minTime = (int) 1e9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        visited = new int[100001];

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        BFS(N, K);
        System.out.println(minTime);
    }

    private static void BFS(int n, int k) {
        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{n, 0});
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int place = now[0];
            int time = now[1];
            visited[place] = 1;
            if (place == k) {
                minTime = Math.min(minTime, time);

            }
            if(0<=place-1&& visited[place-1]==0){
                dq.offer(new int[]{place-1, time+1});
            }
            if(place+1<100001 && visited[place+1]==0){
                dq.offer(new int[]{place+1, time+1});
            }
            if(place*2<100001 && visited[place*2]==0){
                dq.offer(new int[]{place*2, time});
            }

        }

    }
}