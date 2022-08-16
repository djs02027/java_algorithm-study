import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        for (int i=0; i<T;i++){
            int [] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k=0;
            while (st.hasMoreTokens()){
                arr[k]=Integer.parseInt(st.nextToken());
                k++;
            }

            Arrays.sort(arr);
            System.out.println(arr[arr.length-3]);

        }





    }
}