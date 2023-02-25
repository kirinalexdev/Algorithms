
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

// Первоисточник:
// https://github.com/eugenp/tutorials/tree/master/algorithms-modules/algorithms-miscellaneous-2/src/main/java/com/baeldung/algorithms/ga/dijkstra
// https://www.baeldung.com/java-dijkstra


public class Dijkstras_baeldung {
    public static void main(String[] args) {
        var A = new Node("A");
        var B = new Node("B");
        var C = new Node("C");
        var D = new Node("D");
        var E = new Node("E");
        var F = new Node("F");

        A.addDestination(B, 10);
        A.addDestination(C, 15);
        B.addDestination(D, 12);
        B.addDestination(F, 15);
        C.addDestination(E, 10);
        D.addDestination(E, 2);
        D.addDestination(F, 1);
        F.addDestination(E, 5);

        Graph6 graph6 = new Graph6();
        graph6.addNode(A);
        graph6.addNode(B);
        graph6.addNode(C);
        graph6.addNode(D);
        graph6.addNode(E);
        graph6.addNode(F);
        
        // рассчитаем пути от A
        graph6 = Dijkstra.calculateShortestPathFromSource(graph6, A);

        // выведем путь до E
        System.out.println(E.getDistance());
        for (Node node : E.getShortestPath()) {
            System.out.println(node.getName() + " " + node.getDistance());
        }
    }

}

class Dijkstra {
    public static Graph6 calculateShortestPathFromSource(Graph6 graph6, Node source) {

        // ------ Инициализация -------
        source.setDistance(0); // от source до source расстояние нулевое
        var settledNodes = new HashSet<Node>();   // узлы с известным мин. расстоянием от источника
        var unsettledNodes = new HashSet<Node>(); // узлы, до которых мы можем добраться из источника, но мы не знаем мин. расстояния от начального узла
        unsettledNodes.add(source); // Чтобы завершить процесс инициализации, нам нужно добавить узел source к неустановленным узлам,
                                    // чтобы он был выбран первым на этапе оценки

        // ------ Оценка -------
        while (!unsettledNodes.isEmpty()) {
            // выбираем невычисленный узел с минимальным растоянием до него
            var currentNode = lowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            
            for (Map.Entry<Node, Integer> adjacency : currentNode.getAdjacentNodes().entrySet()) {
                var adjacentNode = adjacency.getKey();
                var edgeWeigh = adjacency.getValue();
                
                // вычисляем мин. расстояние до adjacentNode
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph6;
    }

    //!!! переделать на приоритетную очередь?
    private static void calculateMinDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        var sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            var shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node lowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : unsettledNodes) {
            int Distance = node.getDistance();
            if (Distance < lowestDistance) {
                lowestDistance = Distance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}


@Getter
@Setter
class Graph6 {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node A) {
        nodes.add(A);
    }
}

@Getter
@Setter
@ToString(includeFieldNames = false, of = "name")
class Node {
    private String name;
    private LinkedList<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
}
