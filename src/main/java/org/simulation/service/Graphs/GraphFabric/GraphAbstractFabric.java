package org.simulation.service.Graphs.GraphFabric;

import org.simulation.model.entities.WorldMap;
import org.simulation.service.Graphs.Entities.Graph;

public interface GraphAbstractFabric<G extends Graph> {
    public G createGraph(WorldMap worldMap);
}
