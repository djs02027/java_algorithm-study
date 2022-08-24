import java.util.Scanner;

public class Main {
    static int result = 0;

    public static void main(String[] args) {
        String[] template = {"a", "n", "t", "i", "c"};
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String[] words = new String[N];
        int[] alpa = new int[26];
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            words[i] = word;
        }
        for (int i = 0; i < template.length; i++) {
            String st = template[i];
            char[] charArr = st.toCharArray();
            for (char ch : charArr) {
                alpa[ch - 'a'] = 1;
            }
        }
        if (K>=5){
            FindWords(K, alpa, words, 0, 0);
            System.out.println(result);
        }else {
            System.out.println(0);
        }



    }

    private static void FindWords(int K, int[] alpa, String[] words, int total, int index) {
        if (total == K - 5) {
            int tmp = 0;
            for (int i = 0; i < words.length; i++) {
                char[] charArr = words[i].toCharArray();
                boolean flag = false;
                for (char ch : charArr) {
                    if (alpa[ch - 'a'] == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    tmp += 1;
                    result = Integer.max(result, tmp);
                }
            }
            return;


        }
        for (int i = index; i < alpa.length; i++) {
            if (alpa[i] != 1) {
                alpa[i] = 1;
                FindWords(K, alpa, words, total + 1, i);
                alpa[i] = 0;
            }
        }

    }
}