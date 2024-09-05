package org.simulation.service.Graphs.Entities;

public interface Graph<Id, Node> {
    void addNode(Node node);
    Node getNodeById(Id node);
    Node getNodeByCoordinates(Coordinates coordinates);
}
