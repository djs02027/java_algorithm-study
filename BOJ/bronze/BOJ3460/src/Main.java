import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            String bin = Integer.toBinaryString(N);
            for(int j=bin.length()-1; j>=0; j--){
                if (bin.charAt(j)=='1'){
                    System.out.printf("%d ", (bin.length()-j-1));
                }
            }
        }
    }
}