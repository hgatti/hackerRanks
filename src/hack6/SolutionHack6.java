package hack6;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolutionHack6 {

    /*
     * Complete the runningMedian function below.
     */
    // - We use 2 Heaps to keep track of median
    // - We make sure that 1 of the following conditions is always true:
    //    1) maxHeap.size() == minHeap.size()
    //    2) maxHeap.size() - 1 = minHeap.size()
    static double[] runningMedian(int[] a) {

        double[] doubles = new double[a.length];
        ArrayList<Integer> integers = new ArrayList<>();

        //Fila de prioridade
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        double median = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= median) {
                maxHeap.add(a[i]);
            } else {
                minHeap.add(a[i]);
            }

            if (minHeap.size() > maxHeap.size()+1) {
                maxHeap.add(minHeap.peek());
                minHeap.remove();
            }
            if (maxHeap.size() > minHeap.size()+1) {
                minHeap.add(maxHeap.peek());
                maxHeap.remove();
            }

            if (minHeap.size() == maxHeap.size()) {
                median = (maxHeap.peek() + minHeap.peek())/2.0;
            } else if(minHeap.size() > maxHeap.size()) {
                median = (double) minHeap.peek();
            } else if (minHeap.size() < maxHeap.size()) {
                median = (double) maxHeap.peek();
            }
            doubles[i] = median;
        }

        return doubles;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            //bufferedWriter.write(String.valueOf(result[resultItr]));
            //O problema de fazer sort no array pela performance está no print abaixo
            //por resultado
            System.out.println(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                //bufferedWriter.write("\n");
            }
        }

        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }
}
