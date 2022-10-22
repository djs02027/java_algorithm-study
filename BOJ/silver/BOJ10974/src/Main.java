import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N= sc.nextInt();
        int [] visited = new int[N];
        int [] num = new int[N];
        perm(N, visited, num, 0);
    }

    private static void perm(int n, int [] visited, int [] num,  int r) {
        if(n==r){
            StringBuilder sb =new StringBuilder();
            for (int i = 0; i < num.length; i++) {
                sb.append(num[i]+" ");
            }
            System.out.println(sb.toString());

            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]==0){
                visited[i]=1;
                num[r]=i+1;
                perm(n,visited,num,r+1);
                visited[i]=0;
            }


        }
    }
}