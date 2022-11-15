import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");
        int subin = Integer.parseInt(s[0]);
        int syster = Integer.parseInt(s[1]);
        int [] visited = new int [100001];
        Arrays.fill(visited, -1);
        int count= BFS(subin,syster,visited);
        System.out.println(count);
        for (int i = result.size()-1; i >=0 ; i--) {
            System.out.print(result.get(i)+" ");
        }


    }

    private static int BFS(int subin, int syster, int[] visited) {
        Deque<int []> dq = new LinkedList<>();
        dq.add(new int[]{subin,0});
        while (!dq.isEmpty()) {
            int[] now = dq.pollFirst();
            int place = now[0];
            int time = now[1];
            if (place == syster) {
                int idx = place;
                while (idx != subin) {
                    if (idx == subin) {
                        break;
                    }
                    result.add(idx);
                    idx = visited[idx];
                }
                result.add(idx);
                return time;


            }
            if (place - 1 >= 0 && place - 1 < 100001 && visited[place - 1] == -1) {
                dq.add(new int[]{place - 1, time + 1});
                visited[place - 1] = place;
            }
            if (place + 1 >= 0 && place + 1 < 100001 && visited[place + 1] == -1) {
                dq.add(new int[]{place + 1, time + 1});
                visited[place + 1] = place;
            }
            if (place * 2 >= 0 && place * 2 < 100001 && visited[place * 2] == -1) {
                dq.add(new int[]{place * 2, time + 1});
                visited[place * 2] = place;
            }


        }
        return -1;
    }


}