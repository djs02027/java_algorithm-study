import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {
    static int now = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N= br.readLine();
        String [] target = N.split("");
        int M = Integer.parseInt(br.readLine());
        int [] breakButton = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int button=Integer.parseInt(st.nextToken());
            breakButton[button]=1;
        }
        int cnt =abs(Integer.parseInt(N)-now);
        int len = target.length;
        //최대값은 문제에서 500000이라고 되어있으나 리모콘이 9를 제외하고 모두 고장났다면
        // 999999를 눌러서 찾는 경우도 포함되어야 하므로 최대값을 999999으로 설정한다
        for (int i = 0; i <=999999; i++) {
            String [] NowNum = String.valueOf(i).split("");
            boolean check =false;
            for (int j = 0; j < NowNum.length; j++) {
                if(breakButton[Integer.parseInt(NowNum[j])]==1){
                    check=true;
                    break;
                }
            }
            if(!check){
                int min= abs(Integer.parseInt(N)-i)+NowNum.length;
                cnt=Math.min(cnt,min);
            }
        }
        System.out.println(cnt);







    }
}