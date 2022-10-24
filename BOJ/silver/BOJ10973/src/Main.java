import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int step= 0;
    static int sameIdx= 0;
    static List<int []> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int [] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx=0;
        while (st.hasMoreTokens()){
            num[idx]+=Integer.parseInt(st.nextToken());
            idx++;
        }
        int [] visited =new int [N];
        int [] find =new int[N];
        perm(visited, find, num,  N,0,0);


    }

//    private static void perm(int[] visited, int[] find, int[] num, int n, int r, int count) {
//        if(n==r){
//            result.add(find.clone());
//            int same=0;
//            for (int i = 0; i < find.length; i++) {
//                if(find[i]==num[i]){
//                    same+=1;
//                }
//            }
//
//            if(same==n){
//                sameIdx=step;
//                if (sameIdx==0){
//                    System.out.println(-1);
//                }else{
//
//                    int [] tmp = result.get((sameIdx-1));
//                    StringBuilder sb =new StringBuilder();
//                    for (int i = 0; i < tmp.length; i++) {
//                        sb.append(tmp[i]+" ");
//                    }
//                    System.out.println(sb.toString());
//                }
//                System.exit(0);
//            }
//            step+=1;
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if(visited[i]==0){
//                visited[i]=1;
//                find[r]=i+1;
//                perm(visited, find, num, n, r+1, count+1);
//                visited[i]=0;
//            }
//
//        }
//}
}