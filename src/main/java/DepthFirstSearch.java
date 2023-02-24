
// Поиск в глубину в связном графе
// https://cf2.ppt-online.org/files2/slide/n/NnzFOd456oLM9bPREBqJf7eHvGmiwYAQTp108Z/slide-10.jpg

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Graph2 graph = new Graph2();
        graph.addAdjacency(0, 0);
        graph.addAdjacency(0, 3);
        graph.addAdjacency(1, 0);
        graph.addAdjacency(1, 2);
        graph.addAdjacency(1, 5);
        graph.addAdjacency(2, 4);
        graph.addAdjacency(3, 4);
        graph.addAdjacency(3, 5);
        graph.addAdjacency(4, 5);
        graph.addAdjacency(5, 2);

        var marked = new boolean[6];
        var randomVertex = 0;
        DFS(graph, randomVertex, marked); // граф связный поэтому достаточно одной точки входа

    }

    static void DFS(Graph2 graph, int vertex, boolean[] marked) {
        if (marked[vertex]) { // дальше не идем, уже проходили это вершину
            return;
        }

        marked[vertex] = true; // помечам вершину как пройденную
        System.out.println(vertex);

        for (Integer adjacentVertex: graph.getAdjacency().get(vertex)) {
            DFS(graph, adjacentVertex, marked);
        }
    }
}

@Data
@NoArgsConstructor
class Graph2{
    // для каждой вершины хранится список смежных с ней вершин
    private Map<Integer, List<Integer>> adjacency = new HashMap<>();

    // т.к. граф неоринтированный то добавляем смежности в обе стороны
    public void addAdjacency(int vertex1, int vertex2){
        adjacency.putIfAbsent(vertex1, new ArrayList<Integer>());
        adjacency.get(vertex1).add(vertex2);

        adjacency.putIfAbsent(vertex2, new ArrayList<Integer>());
        adjacency.get(vertex2).add(vertex1);
    }
}

