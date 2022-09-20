import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        int mul=1;
        for(int i=1; i<arr.length;i++){
            int gcd=GCD(answer,arr[i]);
            int lcm=answer*arr[i]/gcd;
            answer=lcm;
        }
        return answer;
    }
    public int GCD(int a, int b ){
        int maxv = Math.max(a,b);
        int minv =Math.min(a,b);
        while(maxv%minv!=0){
            int R = maxv%minv;
            maxv=minv;
            minv=R;
        }
        return minv;
    }
}