package hack5;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SolutionHack5 {

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        HashMap<String, Integer> contactsAsSub = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0].equals("add")) {
                //Adiciona todas as substring possiveis
                for (int j = 1; j <= queries[i][1].length(); j++){
                    String sub = queries[i][1].substring(0, j);
                    if (contactsAsSub.get(sub) == null){
                        contactsAsSub.put(sub, 1);
                    } else {
                        contactsAsSub.put(sub, contactsAsSub.get(sub) + 1);
                    }
                }
            } else if (queries[i][0].equals("find")) {
                if (contactsAsSub.get(queries[i][1]) == null){
                    results.add(0);
                } else {
                    //Se o map possuir a substring ele adiciona a quantidade de vezes
                    //que ele possui
                    results.add(contactsAsSub.get(queries[i][1]));
                }
            }
        }
        int[] resulInt = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resulInt[i] = results.get(i);
        }
        return resulInt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
           // bufferedWriter.write(String.valueOf(result[resultItr]));
            System.out.println(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                //bufferedWriter.write("\n");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }
}
