import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        List<String> flags= new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String input = st.nextToken();
        for(int i=0; i<input.length();i++){
            flags.add(String.valueOf(input.charAt(i)));
        }

        int total=0;
        int tmp=1;
        for (int i=0;i< flags.size(); i++){
            if (flags.get(i).equals("(")){
                tmp*=2;
                stack.push(flags.get(i));
            } else if (flags.get(i).equals("[")) {
                tmp*=3;
                stack.push(flags.get(i));


            } else if (flags.get(i).equals(")")) {
                if(stack.empty()==true || stack.peek().equals("(")==false){
                    total=0;
                    break;
                }
                if (flags.get(i-1).equals("(")){
                   total+=tmp;

                }
                stack.pop();
                tmp/=2;


            }
            else if (flags.get(i).equals("]")) {
                if(stack.empty()==true || stack.peek().equals("[")==false){
                    total=0;
                    break;
                }
                if (flags.get(i-1).equals("[")){
                    total+=tmp;

                }
                stack.pop();
                tmp/=3;



            }

        }
        if (stack.empty()==false){
            System.out.println(0);
        }else {
            System.out.println(total);
        }

    }
}