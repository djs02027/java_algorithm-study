import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int TimeMin = (int) 1e9;
    static int count=0;
    static int [] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        visited= new int [100001];
        BFS(N, K);
        System.out.println(TimeMin);
        System.out.println(count);
    }

    private static void BFS(int n, int k) {
        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{n, 0});
        int flag=0;
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int place = now[0];
            int time = now[1];
            visited[place]=1;

            if (place == k) {
                if(flag==0){
                    TimeMin = time;
                    count++;
                    flag=1;
                }else if(flag==1 && TimeMin==time){
                    count++;
                }


            }
            if (0 <= place - 1 && visited[place-1]==0) {
                dq.offer(new int[]{place - 1, time + 1});
            }
            if (place+1 < 100001 && visited[place+1]==0) {
                dq.offer(new int[]{place + 1, time + 1});
            }
            if(place*2 < 100001 && visited[place*2]==0){
                dq.offer(new int[]{place * 2, time + 1});
            }


        }
    }
}