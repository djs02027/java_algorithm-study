import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        int num = Integer.MIN_VALUE;
        int[] alpa = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpa[s.charAt(i) - 'a'] += 1;
        }

        int now = 0;

        for (int i = 0; i < alpa.length; i++) {
            if (num < alpa[i]) {
                num = alpa[i];
                now = i;
            }
        }
        int count =0 ;
        for (int i = 0; i < alpa.length; i++) {
            if (alpa[i]==num){
               count++;
            }
        }
        char c = (char) (now + 65);
        if (count>1) {
            System.out.println("?");
        } else {
            System.out.println(Character.toUpperCase(c));
        }

    }
}