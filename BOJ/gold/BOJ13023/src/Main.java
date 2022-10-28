
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> friends;
    static int M;
    static boolean isSame=false;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        friends = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            friends.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        boolean [] visited ;
        for (int i = 0; i < N; i++) {
            visited = new boolean [N];
            DFS(visited,i, 0);
            if(isSame==true){
                break;
            }
        }
        if(isSame==true) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }





    }

    private static void DFS(boolean [] visited, int x, int r) {



        if(r==4) {
            isSame=true;
            return;
        }
        visited[x]=true;

        for (int i = 0; i < friends.get(x).size(); i++) {
                if (visited[friends.get(x).get(i)] == false) {
                    visited[friends.get(x).get(i)] = true;
                    DFS(visited, friends.get(x).get(i),r+1);
                    visited[friends.get(x).get(i)] = false;
                }


        }




    }


}
/*
5 5
0 1
1 3
1 4
4 3
3 2
* */