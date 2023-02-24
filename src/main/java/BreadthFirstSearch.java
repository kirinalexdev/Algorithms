
// Поиск в глубину в связном графе
// https://cf2.ppt-online.org/files2/slide/n/NnzFOd456oLM9bPREBqJf7eHvGmiwYAQTp108Z/slide-10.jpg

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        Graph graph = new Graph();
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

        var processed = new boolean[6];
        var wasInQueue = new boolean[6]; //!!! может быть не нужно это если нужно узнать все пути?..
        var randomVertex = 0;
        var queue = new LinkedList<Integer>(); //!!! может есть проще очередь?
        // 1.
        BFS(graph, randomVertex, processed, queue, wasInQueue); // граф связный поэтому достаточно одной точки входа


        // Здесь рассматриваем граф
        // - невзвешенный
        // - неориентированный

        // Цель алгоритма
        // - найти самый коротки путь из вершины
        //todo реализовать эту цель

        // 1. Заходим в вершину
        // 2. У вершины получаем смежные с ней и помещаем в очередь (FIFO)
        // 3. Извлекаем поочередно вершины из очереди и выполняем п.1
    }

    static void BFS(Graph graph, int vertex, boolean[] processed, Queue<Integer> queue, boolean[] wasInQueue) {
//        if (processed[vertex]) { // дальше не идем, уже проходили это вершину
//            return;
//        }

        processed[vertex] = true; // помечам вершину как пройденную
        System.out.println(vertex);

        // 2.
        for (Integer adjacentVertex: graph.getAdjacency().get(vertex)) {
            if (!processed[adjacentVertex] && !wasInQueue[adjacentVertex] ) {
                wasInQueue[adjacentVertex] = true; // помечам вершину как побывавшую в очереди
                queue.offer(adjacentVertex);
            }
        }

        while (!queue.isEmpty()) {
            BFS(graph, queue.poll(), processed, queue, wasInQueue);
        }
    }
}

@Data
@NoArgsConstructor
class Graph{
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

