import java.util.*;

public class Main {
    static boolean flag ;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int [] man = new int [9];
        boolean [] check = new boolean[9];
        for (int i = 0; i < 9; i++) {
            man[i]=sc.nextInt();
        }
        Arrays.sort(man);
        FindMan(man, check, 0,0);



    }
    private static void FindMan(int [] man, boolean [] check, int cac, int r){
        if(flag==true){
            return;
        }
        if(r==7 && cac==100){
            for (int i = 0; i < check.length; i++) {
                if(check[i]==true){
                    System.out.println(man[i]);
                }
            }
            flag=true;

        }
        for (int i = r; i < 9; i++) {
            if(!check[i]){
                check[i]=true;
                FindMan(man,check,cac+man[i], r+1);
                check[i]=false;
            }

        }
    }
}