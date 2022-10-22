import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static List<Integer> result = new ArrayList<>();
    static int N;
    static long Maxtotal=Long.MIN_VALUE;
    static long Mintotal=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        String [] ex=br.readLine().split(" ");
        int [] numbers = new int[10];
        int [] tmpArr =new int[N+1];
        recursion(numbers,tmpArr,ex,0);
        String maxV =String.valueOf(Maxtotal);
        String minV =String.valueOf(Mintotal);
        if(maxV.length()<N+1){
            String tmp0="";
            for (int i = 0; i < (N+1)-maxV.length() ; i++) {
                tmp0+="0";
            }
            maxV=tmp0+maxV;
        }
        if(minV.length()<N+1){
            String tmp0="";
            for (int i = 0; i < (N+1)-minV.length() ; i++) {
                tmp0+="0";
            }
            minV=tmp0+minV;
        }
        System.out.println(maxV);
        System.out.println(minV);
    }

    private static void recursion(int[] numbers, int[] tmpArr, String[] ex, int r) {
        if(r==N+1){
            if(comparingNumber(tmpArr, ex)){
                long place =1;
                long tmpsum=0;
                for (int i = tmpArr.length-1 ; i >=0 ; i--) {
                    tmpsum+= (tmpArr[i]*place);
                    place*=10;
                }
                Maxtotal=Math.max(Maxtotal,tmpsum);
                Mintotal=Math.min(Mintotal,tmpsum);

            }

            return;
        }

        for (int i = 0; i <= 9;  i++) {
            if(numbers[i]==0){
                numbers[i]=1;
                tmpArr[r]=i;
                recursion(numbers,tmpArr, ex, r+1);
                numbers[i]=0;

            }

        }

    }

    private static boolean comparingNumber(int[] numbers, String[] ex) {
        int exIdx=0;
        result.clear();
        for (int i = 1; i < numbers.length; i++) {
            int tmpA=numbers[i-1];
            int tmpB=numbers[i];

            if(ex[exIdx].equals("<")){
                if(!(tmpA<tmpB)){
                    return false;
                }
            }else {
                if(!(tmpA>tmpB)){
                    return false;
                }
            }
            exIdx+=1;
        }
        return true;
    }
}