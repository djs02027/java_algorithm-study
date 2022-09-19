import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int i=0;
        int j=people.length-1;
        while(i<=j){
            if(people[j]+people[i]<=limit){
                answer+=1;
                i++;
                j--;
            }else{
                answer+=1;
                j--;
            }
        }
        return answer;
    }
}