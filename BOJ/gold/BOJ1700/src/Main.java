import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int total = 0;
        List <Integer> numbers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            numbers.add(num);
        }
        HashSet<Integer> plug = new HashSet<Integer>();
        for (int i = 0; i < numbers.size(); i++) {
            if (plug.size() < N) {
                if (plug.contains(numbers.get(i)) == true) {
                    continue;
                }
                plug.add(numbers.get(i));
            }
            if (plug.contains(numbers.get(i)) == false) {

                int removeValue = RemovePlug(i, plug, numbers);
                plug.remove(removeValue);
                plug.add(numbers.get(i));
                total += 1;

            }

        }
        System.out.println(total);


    }

    private static int RemovePlug(int index, HashSet<Integer> plug, List<Integer> numbers) {
        Iterator iter = plug.iterator();    // Iterator 사용
        int tagertValue = 0;
        int nowIndex = -1;

        while (iter.hasNext()) {//값이 있으면 true 없으면 false
            int num = (int) iter.next();
            List<Integer> part = numbers.subList( index, numbers.size());

            if (!part.contains(num)) {
                return num;
            }


            if (nowIndex < part.indexOf(num)) {
                nowIndex = part.indexOf(num);
                tagertValue = num;
            }
        }
        ;
        return tagertValue;
    }


}