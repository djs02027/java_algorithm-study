import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int x1 =sc.nextInt();
        int x2 =sc.nextInt();
        int y1 =sc.nextInt();
        int y2 = sc.nextInt();

        int c1 = Math.min(y1-x1, y2-x2);
        int c2= Math.min(x1,x2);

        System.out.println(Math.min(c1,c2));



    }
}