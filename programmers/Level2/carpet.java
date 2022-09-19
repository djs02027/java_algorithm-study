class Solution {
    public int[] solution(int brown, int yellow) {

        int square2 =(brown+4)/2; //가+세
        int space=brown+yellow;//가*세
        int col=0;
        int row=0;
        check:for(int i=1; i<square2;i++){
            for(int j=1; j<square2;j++){
                if(i+j==square2 && i*j==space){
                    col=i;
                    row=j;
                    break check;
                }

            }
        }
        if (col>row){
            int tmp=col;
            col=row;
            row=tmp;
        }
        int[] answer = {row, col};
        return answer;
    }
}