class Solution {
    public int solution(int n) {

        int [] numbers = new int [n+1];
        numbers[0]=0;
        numbers[1]=1;
        for(int i=2; i<n+1;i++){
            numbers[i]=(numbers[i-1]+numbers[i-2])%1234567;
        }
        int answer = numbers[n];
        return answer;
    }


}