import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Node> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] parents = new int[V + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        tree = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            tree.add(new Node(a, b, cost));
        }
        tree.sort(Node::compareTo);
        int total = 0;
        for (Node node : tree) {
            int now_start = node.start;
            int now_end = node.end;
            int now_cost = node.cost;
            if (findParent(parents, now_start) != findParent(parents, now_end)) {
                unionParent(parents, now_start, now_end);
                total += now_cost;
            }

        }
        System.out.println(total);
    }

    public static void unionParent(int[] parents, int now_start, int now_end) {
        int start = findParent(parents, now_start);
        int end = findParent(parents, now_end);
        if (start < end) {
            parents[end] = start;
        } else {
            parents[start] = end;
        }
    }

    public static int findParent(int[] parents, int now_start) {
        if (parents[now_start] != now_start) {
            parents[now_start] = findParent(parents, parents[now_start]);
        }
        return parents[now_start];
    }

}

class Node implements Comparable<Node> {
    int start;
    int end;
    int cost;

    Node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}
