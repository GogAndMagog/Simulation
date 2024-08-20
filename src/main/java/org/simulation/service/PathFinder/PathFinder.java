package org.simulation.service.PathFinder;

import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.Entities.Coordinates;

import java.util.List;

public interface PathFinder {
    public List<Coordinates> findPath(Coordinates startNode, Coordinates target, WorldMap worldMap);
}
