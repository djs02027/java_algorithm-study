import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack <Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else if(s.charAt(i) == ')'){
                if(st.isEmpty()){
                    answer=false;
                    break;
                }
                else{
                    st.pop();
                }
            }
        }
        if(!(st.isEmpty())){
            answer=false;
        }




        return answer;
    }
}