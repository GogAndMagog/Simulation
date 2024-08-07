package org.simulation.service.Graphs;

import java.util.List;

public interface PathFinder<Id, T extends Node<Id>, P extends Graph<Id, T>> {
  public List<Id> findPath(P graph, Id baseNode, Id targetNode);
}
