package org.simulation.service.graphs;

import org.simulation.service.graphs.entity.Coordinates;
import org.simulation.service.graphs.entity.Graph;
import org.simulation.service.graphs.entity.Node;

import java.util.List;

public interface PathFinder<Id, T extends Node<Id>, P extends Graph<Id, T>> {
  List<Coordinates> findPath(P graph, Id baseNode, Id targetNode);
}
