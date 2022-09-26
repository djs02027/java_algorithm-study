
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    static List<Integer> BFSresult = new ArrayList<>();
    static List<Integer> DFSresult = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        ArrayList<Integer>[] num = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            num[i] = new ArrayList<Integer>();

        }
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            num[S].add(E);
            num[E].add(S);
        }
        for (int i = 0; i < N + 1; i++) {
            sort(num[i]);
        }
        int[] visited = new int[N + 1];
        visited[V] = 1;
        DFS(V, num,visited);
        BFS(V, N, num);


        for (int i = 0; i < DFSresult.size(); i++) {
            System.out.printf("%d ", DFSresult.get(i));
        }
        System.out.printf("\n");
        for (int i = 0; i < BFSresult.size(); i++) {
            System.out.printf("%d ", BFSresult.get(i));
        }
    }

    private static void DFS(int v, ArrayList<Integer>[] num, int[] visited) {

       DFSresult.add(v);


        for (int i = 0; i < num[v].size(); i++) {
            if (visited[num[v].get(i)] == 0) {
                visited[num[v].get(i)] = 1;
                DFS(num[v].get(i),num,visited);

            }

        }

    }




    private static void BFS(int v, int n, ArrayList<Integer>[] num) {

        Deque<Integer> dq = new LinkedList<>();
        int[] visited = new int[n + 1];
        visited[v] = 1;
        dq.offer(v);
        while (!(dq.isEmpty())) {
            int now = dq.pollFirst();
            BFSresult.add(now);
            for (int i = 0; i < num[now].size(); i++) {
                if (visited[num[now].get(i)] == 0) {
                    visited[num[now].get(i)] = 1;
                    dq.offer(num[now].get(i));
                }
            }

        }


    }
}