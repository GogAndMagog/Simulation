package org.simulation.service.Graphs;

public interface Graph<Id, Node> {
    public void addNode(Node node);
    public Node getNodeById(Id node);
}
