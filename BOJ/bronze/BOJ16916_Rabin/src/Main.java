//시간초과
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parent = sc.nextLine();
        String patten = sc.nextLine();
        int parent_len = parent.length();
        int patten_len = patten.length();
        long parent_hash = 0;
        long patten_hash = 0;
        long power = 1;
        int cnt = 0;

        for (int i = 0; i < parent_len - patten_len; i++) {
            if (i == 0) {
                for (int j = 0; j < patten_len; j++) {
                    parent_hash += parent.charAt(patten_len - 1 - j) * power;
                    patten_hash += patten.charAt(patten_len - 1 - j) * power;
                    if (j < patten_len - 1) {
                        power *= 2;
                    }
                }
            } else {
                parent_hash = 2 * (parent_hash - (parent.charAt(i - 1) * power)) + parent.charAt(patten_len - 1 + i);
            }
            if (parent_hash == patten_hash) {
                boolean isSame = true;
                for (int j = 0; j < patten_len; j++) {
                    if (parent.charAt(i + j) != patten.charAt(j)) {
                        isSame = false;
                    }
                }
                if (isSame) {
                    cnt = 1;
                }
            }
        }


        System.out.println(cnt);


    }
}