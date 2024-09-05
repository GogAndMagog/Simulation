package org.simulation.service.graph.entity;

public interface Graph<Id, Node> {
    void addNode(Node node);
    Node getNodeById(Id node);
    Node getNodeByCoordinates(Coordinates coordinates);
}
