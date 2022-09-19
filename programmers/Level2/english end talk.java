import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer=new int[2];
        char endWord=' ';
        int count=0;
        List <String> usedList = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            int len = words[i].length()-1;
            if (i==0){
                endWord=words[i].charAt(len);
                usedList.add(words[i]);
                count++;
            }else{
                char startWord=words[i].charAt(0);
                if (endWord==startWord && usedList.contains(words[i])==false){
                    endWord=words[i].charAt(len);
                    usedList.add(words[i]);
                    count++;
                }else{
                    break;
                }
            }
        }
        if(words.length==count){
            answer[0]=0;
            answer[1]=0;

        }else{
            int who=(count%n)+1;
            int turn=(count+n)/n;

            answer[0]=who;
            answer[1]=turn;
        }


        return answer;
    }
}