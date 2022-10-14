import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s =sc.next();
        char [] block = s.toCharArray();
        int [] dp=new int [N];
        Arrays.fill(dp,(int)1e9);
        dp[0]=0;

        int flag=1;
        for(int i=0; i< block.length; i++){
            if(block[i]=='B'){
                for(int j=i; j< block.length; j++){
                    if(block[j]=='O'){
                        dp[j]=Math.min(dp[j],dp[i]+(j-i)*(j-i));

                    }
                }
            }
            else if(block[i]=='O'){
                for(int j=i; j< block.length; j++){
                    if(block[j]=='J'){
                        dp[j]=Math.min(dp[j],dp[i]+(j-i)*(j-i));

                    }
                }
            }
            else if(block[i]=='J'){
                for(int j=i; j< block.length; j++){
                    if(block[j]=='B'){
                        dp[j]=Math.min(dp[j],dp[i]+(j-i)*(j-i));

                    }
                }
            }

        }
        if(dp[N-1]==(int) 1e9){
            System.out.println(-1);
        }else{
            System.out.println(dp[N-1]);
        }

    }
}