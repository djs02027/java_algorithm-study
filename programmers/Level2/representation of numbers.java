class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n;i++){
            int cac=0;
            for(int j=i;j<=n;j++){
                cac+=j;
                if(cac==n){
                    answer+=1;
                }
                if(cac>n){
                    break;
                }
            }
        }


        return answer;
    }
}