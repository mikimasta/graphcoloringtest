import java.util.ArrayList;
import java.util.List;

public class bruteForce {
    //method to convert a List of all the e[d].u, e[d].v to a 2d array of pairs (edges)
    public static Integer[][] to2DArray(List<Integer> numbers) {

        List<List<Integer>> partitions = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i += 2) {
            partitions.add((numbers.subList(i, Math.min(i + 2, numbers.size()))));
        }

        Integer[][] array = new Integer[partitions.size()][];
        for (int i = 0; i < partitions.size(); i++) {
            List<Integer> row = partitions.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }

        return array;
    }

    //method to create a 2d array of all the connections between the vertices (0 - no connection, 1 - connection)
    public static int[][] graph(int vertices, Integer[][] edges) {
        int[][] graph = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = 0;
            }
        }

        for (Integer[] edge : edges) {
            graph[edge[0] - 1][edge[1] - 1] = 1;
            graph[edge[1] - 1][edge[0] - 1] = 1;
        }

        return graph;
    }


    public static boolean colorGraph(int[][] graph, int numberOfColors, int index, int[] color, int vertices) {
        if(index == vertices) {
            return ((canColor(color, graph, vertices)));
        }
        for(int j = 1; j <= numberOfColors; j++) {
            color[index] = j;
            if(colorGraph(graph, numberOfColors, index + 1, color, vertices)) {
                return true ;
            }
            color[index] = 0;
        }
        return false;
    }

    // here, the method checks whether a given vertex is in connection with itself, if not calls colorGraph()

    public static boolean possibleToSolve(int[][] graph, int numberOfColors, int vertices) {
        int[] color = new int[vertices];
        return colorGraph(graph, numberOfColors, 0, color, vertices);
    }


    //canColor() checks whether two adjacent vertices have the same color
    public static boolean canColor(int[] color, int[][] graph, int vertices) {
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if ((graph[i][j] == 1) && (color[i] == color[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}





