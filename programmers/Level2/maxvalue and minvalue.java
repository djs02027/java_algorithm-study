class Solution {
    public String solution(String s) {
        String [] str = s.split(" ");
        int maxValue= -(int) 1e9;
        int minValue= (int) 1e9;
        for(int i=0; i<str.length; i++){
            int num=Integer.parseInt(str[i]);
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }
        String answer = String.valueOf(minValue)+" "+String.valueOf(maxValue);
        return answer;
    }
}