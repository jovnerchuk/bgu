import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  private static class GraphNode {

    private Integer number;
    private final List<GraphNode> connects = new ArrayList<>();

    public GraphNode(Integer number) {
      this.number = number;
    }

    public Integer getNumber() {
      return number;
    }

    public void setNumber(Integer number) {
      this.number = number;
    }

    public List<GraphNode> getConnects() {
      return connects;
    }

  }

  private final List<GraphNode> graphNodes = new ArrayList<>();

  public Graph(final Integer[][] curveList) {
    for (var i = 0; i < curveList.length; i++) {
      graphNodes.add(i, new GraphNode(i));
    }

    for (var i = 0; i < curveList.length; i++) {
      var currentNode = graphNodes.get(i);
      var currentNodeConnections = currentNode.getConnects();

      var connectToNodes = curveList[i];
      for (var connectToNode : connectToNodes) {
        currentNodeConnections.add(graphNodes.get(connectToNode));
      }
    }
  }

  public void addCurve(final Integer node, final Integer toNode) {
    final var graphNode = graphNodes.get(node);
    final var graphNodeConnects = graphNode.getConnects();
    final var graphToNode = graphNodes.get(toNode);
    graphNodeConnects.add(graphToNode);
  }

  public void removeCurve(final Integer node, final Integer toNode) {
    final var graphNode = graphNodes.get(node);
    final var graphNodeConnects = graphNode.getConnects();
    final var graphToNode = graphNodes.get(toNode);
    graphNodeConnects.remove(graphToNode);
  }

  public Integer addNode() {
    final var number = graphNodes.size();
    graphNodes.add(new GraphNode(number));
    return number;
  }

  public void removeNode(final Integer nodeNumber) {
    final var graphNodeToDelete = graphNodes.get(nodeNumber);
    graphNodes.remove(graphNodeToDelete);
    for (var node : graphNodes) {
      final var convertNode = node.getNumber();
      if (convertNode > nodeNumber) {
        node.setNumber(convertNode - 1);
      }
      final var convertConnectionsNode = node.getConnects();
      convertConnectionsNode.remove(graphNodeToDelete);
    }
  }

  @Override
  public String toString() {
    final var stringBuilder = new StringBuilder();
    for (var node : graphNodes) {
      stringBuilder.append(node.getNumber())
          .append(" ")
          .append(getConnectionList(node))
          .append('\n');
    }
    return stringBuilder.toString();
  }

  private static List<Integer> getConnectionList(GraphNode node) {
    return node.getConnects().stream().map(GraphNode::getNumber).collect(toList());
  }

}
