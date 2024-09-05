package org.simulation.service.graphs.entity;

public interface Graph<Id, Node> {
    void addNode(Node node);
    Node getNodeById(Id node);
    Node getNodeByCoordinates(Coordinates coordinates);
}
