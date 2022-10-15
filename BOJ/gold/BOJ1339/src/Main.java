import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            words[i] = s;
        }
        int[] alpa = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char tmp = words[i].charAt(j);
                int placeCount = (int) Math.pow(10, words[i].length() - j - 1);
                alpa[tmp - 'A'] +=placeCount;
            }
        }
        List<wordList> wl = new LinkedList<>();
        for (int i = 0; i < alpa.length ; i++) {
            wl.add(new wordList(alpa[i],(char)('A'+i)));
        }
        wl.sort(wordList::compareTo);

        int num=9;
        for (int i = wl.size()-1; i >=0 ; i--) {
            if(num<0){
                break;
            }
            alpa[(int)wl.get(i).c-'A']= wl.get(i).cost*num;
            num--;
        }
        int total=0;
        for (int i = 0; i < alpa.length; i++) {
            total+=alpa[i];
        }
        System.out.println(total);


    }
}

class wordList implements Comparable<wordList>{
    int cost;
    char c;

    public wordList(int cost, char c) {
        this.cost = cost;
        this.c = c;
    }

    @Override
    public int compareTo(wordList o) {
        return cost-o.cost;
    }
}