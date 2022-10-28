import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int C=sc.nextInt();
        int [] house=new int[N];
        for (int i = 0; i < N ; i++) {
            house[i]= sc.nextInt();
        }
        Arrays.sort(house);
        //지점간의 거리 최소와 최대 설정
        int left=1;
        int right=house[house.length-1]-house[0];
        int answer=0;
        while (left<=right){
            int mid = (left+right)/2;
            int prev=house[0];
            int Setting=1;

            //Setting가 1인 이유
            //https://www.acmicpc.net/board/view/31633
            //직전에 설치했던 집과의 거리를 측정해나가므로
            //두 공유기 사이의 최대 거리가 커질수록
            //설치할 수 있는 공유기의 갯수가 작아진다는 것이다
            //최대한 왼쪽에 설치할수록, 그 다음 공유기는 왼쪽에 설치할 수 있고,
            //더 많이 설치할 수 있게 됩니다.

            for (int i = 1; i < house.length; i++) {
                if(mid<=house[i]-prev)  {
                    Setting++;
                    prev=house[i];
                }


            }
            if(Setting>=C){
                answer=Math.max(answer,mid);
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(answer);
    }
}