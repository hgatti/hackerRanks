package hack1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Solution2 {
    public static class Graph {
        List<List<Integer>> adjLst;
        int size;
        public Graph(int size) {
            adjLst = new ArrayList<>();
            this.size = size;
            while(size-- > 0)
                adjLst.add(new ArrayList<Integer>());
        }

        public void addEdge(int first, int second) {
            adjLst.get(first).add(second);
            adjLst.get(second).add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1);
            //Lista encadeada
            Queue<Integer> que = new LinkedList<>();

            que.add(startId);
            distances[startId] = 0;
            //Hashset dos nos visitados
            HashSet<Integer> seen = new HashSet<>();

            seen.add(startId);
            while(!que.isEmpty()) {
                Integer curr = que.poll();
                for(int node : adjLst.get(curr)) {
                    if(!seen.contains(node)) {
                        que.offer(node);
                        seen.add(node);
                        distances[node] = distances[curr] + 6;
                    }
                }
            }
            return distances;
        }
    }

    public static void printNice(Graph graph) {
        for (int i = 0; i < graph.size; i++) {
            System.out.println(graph.adjLst.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("quantas queries v2");
        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                System.out.println("(u,v)");
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }
            printNice(graph);

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}