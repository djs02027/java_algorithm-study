
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//클래스를 통해 객체 생성시 오름차순 정렬
class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> arr;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int result = dijkstra(start, end, N);
        System.out.println(result);
    }

    public static int dijkstra(int start, int end, int N) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node nowNode = q.poll();
            int now = nowNode.end;
            if (!visited[now]) {
                visited[now] = true;
                for (Node node : arr.get(now)) {
                    if (!visited[node.end] && dist[node.end] > dist[now] + node.weight) {
                        dist[node.end] = dist[now] + node.weight;
                        q.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }

}
