import java.util.*;
class Solution {
    public int[] solution(String s) {
        int cnt=0;
        int binaryCnt=0;
        while(s.length()>1){
            String tmp=s.replace("0","");
            if (s.length()>tmp.length()){
                cnt+=(s.length()-tmp.length());

                s=Integer.toBinaryString(tmp.length());
                binaryCnt+=1;
            }
            else{
                s=Integer.toBinaryString(tmp.length());
                binaryCnt+=1;
            }
        }

        int[] answer = {binaryCnt,cnt};
        return answer;
    }
}