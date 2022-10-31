import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end;
    int weight;
    Node(int end, int weight){
        this.end=end;
        this.weight=weight;
    }

    @Override
    public int compareTo(Node o){
        return  weight-o.weight;
    }
}
public class Main {

    static ArrayList<ArrayList<Node>> graph;
    static int [] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        graph=new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
        }
        StringTokenizer st =new StringTokenizer(br.readLine());
        int StartPoint=Integer.parseInt(st.nextToken());
        int EndPoint=Integer.parseInt(st.nextToken());

        distance=new int [N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int result=dijkstra(StartPoint,EndPoint, N);
        System.out.println(result);




    }

    public static int dijkstra(int start, int end, int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean [] visited = new boolean[N+1];
        distance[start]=0;

        pq.add(new Node(start,0));
        while (!pq.isEmpty()){
            Node now=pq.poll();
            visited[now.end]=true;
            for(Node next : graph.get(now.end)){
                if(!visited[next.end]&&distance[next.end]>distance[now.end]+next.weight){
                    distance[next.end]=distance[now.end]+next.weight;
                    pq.add(new Node(next.end, distance[next.end]));
                }
            }
        }
        return distance[end];
    }

}
