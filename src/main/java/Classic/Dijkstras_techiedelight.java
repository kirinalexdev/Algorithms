package Classic;
// https://www.techiedelight.com/ru/single-source-shortest-paths-dijkstras-algorithm/

import java.util.*;

public class Dijkstras_techiedelight
{
    public static void main(String[] args) {
        // инициализируем ребра в соответствии с приведенной выше диаграммой
        // (u, v, w) представляет ребро из вершины `u` в вершину `v` с весом `w`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 10),
                new Edge(0, 4, 3),
                new Edge(1, 2, 2),
                new Edge(1, 4, 4),
                new Edge(2, 3, 9),
                new Edge(3, 2, 7),
                new Edge(4, 1, 1),
                new Edge(4, 2, 8),
                new Edge(4, 3, 2)
        );

        int n = 5; // общее количество узлов в Graph4 (от 0 до 4)

        Graph4 graph = new Graph4(edges, n);

        // запускаем алгоритм Дейкстры с каждого узла
        for (int source = 0; source < n; source++) {
            findShortestPaths(graph, source, n);
        }
    }


    // Запускаем алгоритм Дейкстры на заданном Graph4
    public static void findShortestPaths(Graph4 graph, int source, int n) {
        //!!! написать что именно тут хранится
        // Класс для хранения узла кучи
        class Node {
            int vertex, weight;

            public Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }

        // создаем мини-кучу и проталкиваем исходный узел с расстоянием 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        // устанавливаем начальное расстояние от источника на `v` как бесконечность
        List<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        // расстояние от источника до себя равно нулю
        dist.set(source, 0);

        // для отслеживания вершин, для которых минимум стоимости уже найдена
        boolean[] done = new boolean[n];
        done[source] = true;

        // сохраняет предыдущую вершину (в путь печати)
        int[] prev = new int[n];
        prev[source] = -1;

        // работать до тех пор, пока мини-куча не станет пустой
        while (!minHeap.isEmpty()) {
            // Удалить и вернуть лучшую вершину
            Node node = minHeap.poll();

            // получаем номер вершины
            int u = node.vertex;

            // делаем для каждого соседа `v` из `u`
            for (Edge edge: graph.adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                // Шаг релаксации
                if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            // помечаем вершину `u` как выполненную, чтобы она больше не поднималась
            done[u] = true;
        }

        List<Integer> route = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                Graph4.getRoute(prev, i, route);
                System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
                        source, i, dist.get(i), route);
                route.clear();
            }
        }
    }
}

// Класс для хранения ребра Graph4
class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph4 {
    //!!! кажетяс можно обойтись просто списком List<Edge>, иначе сейчас дублирование
    // списки смежности
    List<List<Edge>> adjList = null;

    Graph4(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // добавляем ребра
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge);
        }
    }

    static void getRoute(int[] prev, int i, List<Integer> route) {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }
}
