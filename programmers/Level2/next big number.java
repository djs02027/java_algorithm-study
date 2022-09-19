class Solution {
    public int solution(int n) {

        String s="";
        s=Integer.toString(n,2);
        int count=0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)=='1'){
                count+=1;
            }
        }
        int num=n;
        while(true){
            num++;
            int tmpCount=0;
            String tmp="";
            tmp=Integer.toString(num,2);
            for(int i=0; i<tmp.length(); i++){
                if (tmp.charAt(i)=='1'){
                    tmpCount+=1;
                }
            }
            if(count==tmpCount){
                break;
            }

        }
        int answer = num;
        return answer;
    }
}