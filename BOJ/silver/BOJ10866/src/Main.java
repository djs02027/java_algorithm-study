import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String [] now = br.readLine().split(" ");
            switch (now[0]) {
                case "push_back": {
                    dq.offerLast(Integer.parseInt(now[1]));
                    break;
                }
                case "push_front": {
                    dq.offerFirst(Integer.parseInt(now[1]));
                    break;
                }
                case "front": {
                    if (!dq.isEmpty()) {
                        sb.append(dq.getFirst()).append('\n');
                    } else {
                        sb.append(-1).append('\n');

                    }
                    break;
                }
                case "back": {
                    if (!dq.isEmpty()) {
                        sb.append(dq.getLast()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                }
                case "pop_front": {
                    if (dq.size() > 0) {
                        sb.append(dq.pollFirst()).append('\n');

                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                }
                case "pop_back": {
                    if (dq.size() > 0) {
                        sb.append(dq.pollLast()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
                }
                case "size": {
                    sb.append(dq.size()).append('\n');
                    break;
                }
                case "empty": {
                    if (dq.size() > 0) {
                        sb.append(0).append('\n');
                    } else {
                        sb.append(1).append('\n');
                    }
                    break;
                }

            }

        }

        System.out.println(sb);

    }
}