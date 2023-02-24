
// Обход в ширину в связном ориентированном графе
// https://cf2.ppt-online.org/files2/slide/n/NnzFOd456oLM9bPREBqJf7eHvGmiwYAQTp108Z/slide-10.jpg

// https://www.planttext.com
//
//@startuml
//digraph G {
//        0 -> 0
//        0 -> 3
//        1 -> 0
//        1 -> 2
//        1 -> 5
//        2 -> 4
//        3 -> 4
//        3 -> 5
//        4 -> 5
//        5 -> 2
//        }
//@enduml

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        var graph = new Graph7();
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

        var dim = 6;

        // Можно еще добавить рассчет расстояний, запоминание пути

        // 0 - не обработанные
        // 1 - в очереди
        // 2 - обработанные
        var state = new byte[dim];
        var rootVertex = 0;
        var queue = new ArrayDeque<Integer>();
        BFS(graph, rootVertex, state, queue); // граф связный поэтому достаточно одной точки входа
    }

    static void BFS(Graph7 graph6, int v1, byte[] state, Queue<Integer> queue) {
        state[v1] = 2; // помечам вершину как пройденную
        System.out.println(v1);

        // обходим смежные вершины помещаем в очередь
        for (Integer adjacentV: graph6.getAdjacency().get(v1)) {
            if (state[adjacentV] == 0) {
                state[adjacentV] = 1; // помечам вершину как в очереди
                queue.offer(adjacentV);
            }
        }

        // обходим вершины в очереди
        while (!queue.isEmpty()) {
            var v2 = queue.poll();
            BFS(graph6, v2, state, queue);
        }
    }
}

@Data
@NoArgsConstructor
class Graph7{
    // для каждой вершины хранится список смежных с ней вершин
    private Map<Integer, List<Integer>> adjacency = new HashMap<>();

    // граф оринтированный, поэтому связности только в одну сторону добавляем
    public void addAdjacency(int vertex1, int vertex2){
        adjacency.putIfAbsent(vertex1, new ArrayList<Integer>());
        adjacency.get(vertex1).add(vertex2);
    }
}

