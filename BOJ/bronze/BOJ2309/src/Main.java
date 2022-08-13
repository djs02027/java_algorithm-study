import java.util.*;

public class Main {
    static boolean flag = false;

    public static void DFS(List<Integer> man, int depth, List<Integer> visited) {
        if (flag == true) {
            return;
        }
        if (depth == 7) {
            int total = 0;
            for (int i = 0; i < visited.size(); i++) {
                total += visited.get(i);
            }
            if (total == 100) {

                for (int i = 0; i < visited.size(); i++) {
                    System.out.println(visited.get(i));
                }
                flag = true;
            }
        } else {
            for (int i = depth; i < man.size(); i++) {
                if (!visited.contains(man.get(i))) {
                    visited.add(man.get(i));
                    DFS(man, depth + 1, visited);
                    visited.remove(visited.size() - 1);

                }
            }
        }


    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            int N = sc.nextInt();
            numbers.add(N);
        }
        List<Integer> visited = new ArrayList<>();


        Collections.sort(numbers);
        DFS(numbers, 0, visited);


    }
}