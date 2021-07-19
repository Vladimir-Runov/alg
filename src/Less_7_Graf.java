
/*
1. Реализовать программу, в которой задается граф из 10 вершин.
   Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */

import java.util.Arrays;

public class Less_7_Graf {
/*  private static final int[][] gr = {
            {0, 1, 1, 0, 0, 0, 0, 0, },
            {1, 0, 1, 0, 1, 0, 0, 0, },
            {1, 1, 0, 0, 0, 1, 0, 0, },
            {0, 0, 0, 0, 1, 1, 0, 0, },
            {0, 1, 0, 1, 0, 0, 1, 0, },
            {0, 0, 1, 1, 0, 0, 0, 1, },
            {0, 0, 0, 0, 1, 0, 0, 1, },
            {0, 0, 0, 0, 0, 1, 1, 0, },
    };
    private static final int[] vu = {2, 1, 3, 4, 0, 5, 6, 7};
*/

    public static void go() {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1); //AB
        graph.addEdge(1, 2); //BC
        graph.addEdge(0, 3); //AD
        graph.addEdge(3, 4); //DE

        graph.bfs_w(0);
    }

}
