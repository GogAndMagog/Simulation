package org.simulation.service.graph;

import org.simulation.service.graph.entity.Coordinates;
import org.simulation.service.graph.entity.Graph;
import org.simulation.service.graph.entity.Node;

import java.util.List;

public interface PathFinder<Id, T extends Node<Id>, P extends Graph<Id, T>> {
  List<Coordinates> findPath(P graph, Id baseNode, Id targetNode);
}
