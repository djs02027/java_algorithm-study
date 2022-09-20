class Solution {
    public long solution(int n) {
        long answer = 0;
        long [] numbers=new long [2001];
        numbers[1]=1;
        numbers[2]=2;
        for(int i=3; i<2001; i++){
            numbers[i]=(numbers[i-1]+numbers[i-2])% 1234567;
        }
        answer=numbers[n];
        return answer;
    }
}