import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String part = sc.next();

        int result = KMP(text, part);
        System.out.println(result);
    }

    public static int KMP(String text, String part) {
        int t_len = text.length();
        int p_len = part.length();
        int[] lps = LPS(part);
        int i = 0;
        int j = 0;
        int match = 0;
        while (i < t_len) {
            if (text.charAt(i) == part.charAt(j)) {
                i += 1;
                j += 1;
            } else if (text.charAt(i) != part.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i += 1;
                }

            }
            if (j == p_len) {
                j = lps[j - 1];
                match = 1;

            }
        }
        return match;
    }

    public static int[] LPS(String part) {
        int[] lps = new int[part.length()];
        Arrays.fill(lps, 0);

        int length = 0;
        int index = 1;

        while (index < part.length()) {
            if (part.charAt(index) == part.charAt(length)) {
                length += 1;
                lps[index] = length;
                index += 1;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[index] = 0;
                    index += 1;
                }
            }
        }
        return lps;
    }

}