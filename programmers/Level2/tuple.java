import java.util.*;
class Solution {
    public int[] solution(String s) {
        int [] answer;
        int [] num =new int[100001];
        String tmp="";
        s=s.replace("{","");
        s=s.replace("}","");
        s=s.replace(","," ");
        String [] n=s.split(" ");

        for(int i=0; i<n.length; i++){

            num[Integer.parseInt(n[i])]+=1;
        }
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<num.length; i++){
            if(num[i]!=0){
                mp.put(num[i],i);
            }
        }
        List<Integer> keySetmp = new ArrayList<>(mp.keySet());
        Collections.reverse(keySetmp);

        int len= mp.size();
        answer=new int [len];
        int i=0;
        for(int k : keySetmp){
            answer[i]=mp.get(k);
            i++;
        }




        return answer;

    }
}