
import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {
    static int now = 100;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String N= sc.next();
        int target=Integer.parseInt(N);
        int M = sc.nextInt();
        int [] breakButton = new int[10];
        for (int i = 0; i < M; i++) {
            int button=sc.nextInt();
            breakButton[button]=1;
        }
        int cnt =abs(target-now);
        //최대값은 문제에서 500000이라고 되어있으나 리모콘이 9를 제외하고 모두 고장났다면
        // 999999를 눌러서 찾는 경우도 포함되어야 하므로 최대값을 999999으로 설정한다
        for (int i = 0; i <=999999; i++) {
            String NowNum = String.valueOf(i);
            int len=NowNum.length();
            boolean check =false;
            for (int j = 0; j < len; j++) {
                if(breakButton[NowNum.charAt(j)-'0']==1){
                    check=true;
                    break;
                }
            }
            if(!check){
                int min= abs(target-i)+len;
                cnt=Math.min(cnt,min);
            }
        }
        System.out.println(cnt);







    }
}