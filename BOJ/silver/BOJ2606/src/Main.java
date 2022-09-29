import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N ;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer>[] number =new ArrayList[N+1];
        for (int i=0; i<N+1; i++){
            number[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            int S =sc.nextInt();
            int E=sc.nextInt();
            number[S].add(E);
            number[E].add(S);
        }
        int start=1;
        count=0;
        BFSFind(start,number);
        System.out.println(count);


    }
    private static void BFSFind(int start, ArrayList<Integer>[] number){
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(start);
        int [] visited = new int [N+1];
        visited[start]=1;
        while (!dq.isEmpty()){
            int now = dq.pollFirst();
            for (int i=0; i<number[now].size();i++){
                if(visited[number[now].get(i)]==0){
                    visited[number[now].get(i)]=1;
                    count++;
                    dq.offer(number[now].get(i));
                }
            }


        }
    }
}