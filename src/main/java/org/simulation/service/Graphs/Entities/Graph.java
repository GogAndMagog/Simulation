package org.simulation.service.Graphs.Entities;

public interface Graph<Id, Node> {
    public void addNode(Node node);
    public Node getNodeById(Id node);
    public Node getNodeByCoordinates(Coordinates coordinates);
}
