package org.simulation.service.Simulation;

import org.simulation.model.entities.Entity;
import org.simulation.service.Graphs.Entities.Coordinates;

import java.util.List;

public interface TargetIdentifier {
    public Coordinates getClosest(Coordinates from, List<Entity> entities, Class<?>... targetClasses);
}
