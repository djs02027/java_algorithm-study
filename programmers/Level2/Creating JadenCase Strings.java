class Solution {
    public String solution(String s) {
        String answer = "";
        int blank=0;
        for(int i=0;i<s.length();i++){
            int c= s.charAt(i);
            if(i==0){ //첫번째 문자열
                if(c>='a'&& c<='z'){ //소문자면 대문자로 변환
                    answer+=String.valueOf((char) (s.charAt(i)-32));
                    continue;
                }
                else{
                    answer+=String.valueOf(s.charAt(i));
                    continue;
                }
            }
            if(s.charAt(i)==' '){//빈칸
                answer+=" ";
                blank=i;
            }
            else if(i>0 && s.charAt(i-1)==' '&& s.charAt(i)!=' '){ //빈칸뒤
                if(c>='a'&& c<='z'){
                    answer+=String.valueOf((char) (s.charAt(i)-32));
                }else{
                    answer+=String.valueOf(s.charAt(i));
                }

            }
            else{
                if(c>='A'&& c<='Z'){
                    char changeAlpa=(char) (c+32);
                    answer+=String.valueOf(changeAlpa);
                }
                else{
                    answer+=String.valueOf(s.charAt(i));
                }
            }

        }

        return answer;
    }
}