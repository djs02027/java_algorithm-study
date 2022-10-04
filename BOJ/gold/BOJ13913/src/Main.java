import java.util.*;

public class Main {
    static  int [] visited;

    static  ArrayList<Integer> result;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        visited = new  int [100001];
        Arrays.fill(visited, -1);
        result=new ArrayList<>();
        int time = BFS(N,K);
        System.out.println(time);
        for(int i= result.size()-1; i>=0; i--){
            System.out.print(result.get(i)+" ");
        }
    }

    private static int BFS(int n, int k) {
        Deque<int []> dq = new LinkedList<>();
        dq.offer(new int []{n,0});
        visited[n]=n;
        while (!dq.isEmpty()){
            int [] now = dq.pollFirst();
            int place = now[0];
            int time = now[1];

            if (place==k){
                int idx =place;
                while (idx!=n){
                    if(idx == n){
                        break;
                    }
                    result.add(idx);
                    idx=visited[idx];
                }
                result.add(n);
                return time;

            }
            if (0<=place-1&& visited[place-1]==-1){
                dq.offer(new int []{place-1,time+1});
                visited[place-1]=place;
            }
            if (place+1<100001 && visited[place+1]==-1){
                dq.offer(new int []{place+1,time+1});
                visited[place+1]=place;
            }
            if(place*2<100001 && visited[place*2]==-1){
                dq.offer(new int []{place*2,time+1});
                visited[place*2]=place;
            }
        }
        return n;
    }
}