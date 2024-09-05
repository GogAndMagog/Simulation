package org.simulation.service.Graphs;

import org.simulation.service.Graphs.Entities.Coordinates;
import org.simulation.service.Graphs.Entities.Graph;
import org.simulation.service.Graphs.Entities.Node;

import java.util.List;

public interface PathFinder<Id, T extends Node<Id>, P extends Graph<Id, T>> {
  List<Coordinates> findPath(P graph, Id baseNode, Id targetNode);
}
