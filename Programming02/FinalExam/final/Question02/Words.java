package Question02;

import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {

        String inputStr = " "; // string for showing input text
        ArrayList<String> wordsList = new ArrayList<>(); // List to save after removing arrays with duplicate chars
        int inputNum;    // array size
        Scanner kb = new Scanner(System.in);

        System.out.println("Input the number of array size : ");
        inputNum = kb.nextInt();
        String[] words = new String[inputNum];  ;  // words array =

        System.out.println("Input the words (Words are separated by the enter key)  : ");
        for (int i = 0; i < inputNum; i++) {
            words[i] = kb.next();
            wordsList.add(words[i]);
            inputStr = inputStr + " , " + words[i];
        }

       ArrayList<Integer> index = new ArrayList<>();
        int count  = 0;
        int findIndex = 0;
        int remainSize = wordsList.size();
        while(count < inputNum) {
            boolean flag = false;
            for (int i = 0; i < words[count].length(); i++) {
                String temp = String.valueOf(words[count].charAt(i));
                findIndex = findChar(wordsList, temp, count);
                if(findIndex>0){
                    flag = true;
                    wordsList.remove(findIndex);
                }
                // before the compare, list was removed.... it's error
            }
            if(flag) {
                wordsList.remove(count);
            }
         count++;
        }

        String result = " ";
        int output = 1;
        for (int i = 0; i < wordsList.size(); i++) {
            result  = result + "[ " + wordsList.get(i) + " ] " ;
            output = wordsList.get(i).length() * output;
        }


        System.out.println("Input : words = " + inputStr);

        if(wordsList.size() < 2){
            System.out.println("Output : 0");
            System.out.println("No such pair of word.");
        }else{
            System.out.println("Output : " + output);
            System.out.print("Explanation : The tow words can be " + result);
        }
    }

    // for find the char inside each array
    public static int findChar(ArrayList<String> wordsList, String ch, int index){
        // if find the same char, it return index number , other wise return 0;
       int findIndex = 0;
        for (int i = index+1; i < wordsList.size() ; i++) {
            if(wordsList.get(i).contains(ch)){
                findIndex =i;
            }
        }
        return findIndex;
    }

}
