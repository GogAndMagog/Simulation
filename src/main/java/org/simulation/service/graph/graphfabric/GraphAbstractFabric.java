package org.simulation.service.graph.graphfabric;

import org.simulation.model.entity.WorldMap;
import org.simulation.service.graph.entity.Graph;

public interface GraphAbstractFabric<G extends Graph> {
    public G createGraph(WorldMap worldMap);
}