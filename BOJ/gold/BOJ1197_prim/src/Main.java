import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Node>> tree;
    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();
        for (int i = 0; i < (V + 1); i++) {
            tree.add(new ArrayList<>());

        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            tree.get(a).add(new Node(b, cost));
            tree.get(b).add(new Node(a, cost));

        }
        int result = Prim(1, 0, tree);
        System.out.println(result);
    }

    public static int Prim(int start, int cost, ArrayList<ArrayList<Node>> tree) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, cost));
        int count = 0;
        int answer = 0;
        while (count < V) {

            Node nowNode = q.poll();
            int now = nowNode.end;
            int nowcost = nowNode.cost;


            if (visited[now] == true) {
                continue;
            }
            visited[now] = true;
            answer += nowcost;
            count += 1;
            for (Node node : tree.get(now)) {
                q.add(new Node(node.end, node.cost));
            }

        }
        return answer;


    }
}

class Node implements Comparable<Node> {
    int end;
    int cost;


    public Node(int end, int cost) {

        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}