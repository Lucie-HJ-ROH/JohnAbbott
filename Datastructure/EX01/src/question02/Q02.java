package question02;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Stack;

public class Q02 {
    private static final int SSIZE = 200;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give me the string : ");
        String inputStr = sc.nextLine();
        String[] str = new String[SSIZE];
        Stack<String> stack = new Stack<String>();

        System.out.println(inputStr);

        str = inputStr.split("");

        for (int i = 0; i < str.length; i++) {

            if(str[i] == null) {
                break;
            }
            if(str[i].equals("(") ||str[i].equals("{") || str[i].equals("[")){
                stack.push(str[i]);
            }else if(str[i].equals(")")&&(stack.peek().equals("("))){
                stack.pop();
            }else if(str[i].equals("}")&&(stack.peek().equals("{"))){
                stack.pop();
            }else if(str[i].equals("]")&&(stack.peek().equals("["))){
                stack.pop();
            }
         }

        System.out.println(stack);

        if(stack.size()!=0){
            System.out.println("Error : Mismatch Detected!");
        }else{
            System.out.println("Good : String is correct!");
        }

    }



}
