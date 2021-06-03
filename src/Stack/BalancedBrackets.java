package Stack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        System.out.println("starting isBalanced() with " + s);
        Map<Character, Character> bracketMap = new HashMap<Character,Character>();
        bracketMap.put('{','}');
        bracketMap.put('(',')');
        bracketMap.put('[',']');

        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        try{
            for(char c: s.toCharArray()) {
                if(bracketMap.containsKey(c)) {
                    System.out.println("pushing to stack " + c);
                    stack.push(c);
                } else if(c != bracketMap.get(stack.pop())) {
                    return "NO";
                }
            }
        } catch(Exception e) {
            return "NO";
        }
        if(stack.isEmpty()){
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class BalancedBrackets {
    /*
    Should return back
        3
        {[()]}
        {[(])}
        {{[[(())]]}}
        YES
        NO
        YES
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();
            String result = Result.isBalanced(s);
            System.out.println(result);
        }
        bufferedReader.close();
    }
}
