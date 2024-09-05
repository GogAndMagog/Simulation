package org.simulation.service.graphs.graphfabric;

import org.simulation.model.entity.WorldMap;
import org.simulation.service.graphs.entity.Graph;

public interface GraphAbstractFabric<G extends Graph> {
    public G createGraph(WorldMap worldMap);
}
