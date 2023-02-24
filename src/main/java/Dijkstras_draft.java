//
//// Обход в ширину в связном ориентированном графе
//// https://cf2.ppt-online.org/files2/slide/n/NnzFOd456oLM9bPREBqJf7eHvGmiwYAQTp108Z/slide-10.jpg
//
//// https://www.planttext.com
////
////@startuml
////digraph G {
////        0 -> 0
////        0 -> 3
////        1 -> 0
////        1 -> 2
////        1 -> 5
////        2 -> 4
////        3 -> 4
////        3 -> 5
////        4 -> 5
////        5 -> 2
////        }
////@enduml
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.*;
//
//public class Dijkstras {
//
//    public static void main(String[] args) {
//        var graph = new Graph3();
//        graph.addAdjacency(1, 2, 7);
//        graph.addAdjacency(1, 3, 9);
//        graph.addAdjacency(1, 6, 14);
//        graph.addAdjacency(2, 3, 10);
//        graph.addAdjacency(2, 4, 15);
//        graph.addAdjacency(6, 3, 2);
//        graph.addAdjacency(6, 5, 9);
//        graph.addAdjacency(5, 4, 6);
//        graph.addAdjacency(3, 4, 11);
//
//        var dim = 6 + 1; // 1 фейковый нулевой, потом удалить, сделать нумерацию с нуля
//
//        // Можно еще добавить рассчет расстояний, запоминание пути
//
//        // 0 - не обработанные
//        // 1 - в очереди
//        // 2 - обработанные
//        var state = new byte[dim];
//
//        var weighs = new int[dim]; // веса вершин
//        for (int i = 1; i < dim ; i++) {
//            weighs[i] = 9999; // бесконечность
//        }
//
//        var rootVertex = 1;
//        weighs[rootVertex] = 0;
//
//        var queue = new ArrayDeque<Integer>(); //!!! надо?
//        BFS(graph, rootVertex, state, weighs, queue); // граф связный поэтому достаточно одной точки входа
//    }
//
//    //!!! переименовать
//    static void BFS(Graph3 graph, int v1, byte[] state, int[] weighs, Queue<Integer> queue) {
//        state[v1] = 2; // помечам вершину как обработанную !!!или потом?
//        System.out.println(v1);
//
//        var adjacency2 = graph.getAdjacency().get(v1);
//        var weighs2 = graph.getWeighs().get(v1);
//        for (int i = 0; i < adjacency2.size(); i++) {
//
//
//        }
////        // обходим смежные вершины помещаем в очередь
////        for (Integer adjacentV: graph.getAdjacency().get(v1)) {
////            if (state[adjacentV] == 0) {
////                state[adjacentV] = 1; // помечам вершину как в очереди
////                queue.offer(adjacentV);
////            }
//    }
//
////        // обходим вершины в очереди
////        while (!queue.isEmpty()) {
////            var v2 = queue.poll();
////            BFS(graph, v2, state, queue);
////        }
//    //  }
//    }
//}
//
//@Data
//@NoArgsConstructor
//class Graph3{
//    // для каждой вершины хранится список смежных с ней вершин
//    private Map<Integer, List<Integer>> adjacency = new HashMap<>();
//    // для каждой вершины хранится список весов путей со смежными вершинами
//    private Map<Integer, List<Integer>> weighs = new HashMap<>();
//
//    // смежные вершины и веса путей сопоставляются по инексам
//
//    // граф неоринтированный
//    public void addAdjacency(int vertex1, int vertex2, int weight){
//        // туда
//        adjacency.putIfAbsent(vertex1, new ArrayList<Integer>());
//        adjacency.get(vertex1).add(vertex2);
//        weighs.putIfAbsent(vertex1, new ArrayList<Integer>());
//        weighs.get(vertex1).add(weight);
//
//        // обратно
//        adjacency.putIfAbsent(vertex2, new ArrayList<Integer>());
//        adjacency.get(vertex2).add(vertex1);
//        weighs.putIfAbsent(vertex2, new ArrayList<Integer>());
//        weighs.get(vertex2).add(weight);
//    }
////    // для каждой вершины хранится список смежных с ней вершин
////    private Map<Integer, List<Map<Integer, Integer>>> adjacency = new HashMap<>();
////
////    // граф неоринтированный
////    public void addAdjacency(int vertex1, int vertex2, int weight){
////        adjacency.putIfAbsent(vertex1, new ArrayList<Map<Integer, Integer>>());
////
////        adjacency.get(vertex1).add(new HashMap<Integer, Integer>());
////
////        adjacency.putIfAbsent(vertex2, new ArrayList<Integer>());
////        adjacency.get(vertex1).add(vertex1);
////    }
//}
//
