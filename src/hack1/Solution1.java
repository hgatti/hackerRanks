package hack1;

import java.util.*;

//Nao funciona
public class Solution1 {

    public static class Graph {
        List<List<Integer>> adjLst;
        int size;
        int infinityValue = -1;

        public Graph(int size) {
            adjLst = new ArrayList<>();
            this.size = size;

            while(size-- > 0) {
                ArrayList<Integer> integers = new ArrayList<>();
                for (int i = 0; i < this.size; i++) {
                    integers.add(i, 99);
                }
                adjLst.add(integers);
            }
        }

        public void addEdge(int first, int second) {
            this.adjLst.get(first).set(second, 6);
            this.adjLst.get(first).set(first, 0);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int dist[] = new int[this.size];
            Boolean sptSet[] = new Boolean[this.size];
            Arrays.fill(dist, infinityValue);
            Arrays.fill(sptSet, false);

            dist[startId] = 0;

            for (int count = 0; count < this.size - 1; count++) {
                int u = minDistance(dist, sptSet);

                sptSet[u] = true;

                for (int v = 0; v < this.size; v++)
                    if (!sptSet[v]
                            && this.adjLst.get(u).get(v) != 0
                            && dist[u] != infinityValue
                            && dist[u] + this.adjLst.get(u).get(v) > dist[v]) {
                        dist[v] = dist[u] + this.adjLst.get(u).get(v);
                    }
            }
            return dist;
        }

        int minDistance(int dist[], Boolean sptSet[])
        {
            int min = infinityValue, min_index = -1;

            for (int v = 0; v < this.size; v++)
                if (!sptSet[v]
                        && dist[v] >= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }
    }

    public static void printNice(Graph graph) {
        for (int i = 0; i < graph.size; i++) {
            System.out.println(graph.adjLst.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("quantas queries");
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
