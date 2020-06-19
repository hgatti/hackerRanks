package hack4;

import java.io.*;
import java.util.*;

public class SolutionHack4 {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i< s.length() ;i++) {

            if (s.charAt(i) == '{'
                    || s.charAt(i) == '('
                    || s.charAt(i) == '[') {
                stack.push(String.valueOf(s.charAt(i)));
            }

            if (s.charAt(i) == '}'
                    || s.charAt(i) == ')'
                    || s.charAt(i) == ']') {

                if (stack.isEmpty()) {
                    return "NO";
                } else if ( !isPar(stack.pop().charAt(0), s.charAt(i)) ) {
                    return "NO";
                }
            }

        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }

    }

    static boolean isPar(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
