import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack <Character> st= new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(i==0){
                st.push(s.charAt(i));
                continue;
            }
            if(st.empty()==false&&st.peek()==s.charAt(i)){
                st.pop();

            }else{
                st.push(s.charAt(i));
            }


        }
        if(st.empty()==true){
            answer=1;
        }else{
            answer=0;
        }


        return answer;
    }
}