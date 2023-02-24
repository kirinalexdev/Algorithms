import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

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
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph6;
    }

    private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
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
