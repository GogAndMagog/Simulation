package org.simulation.service.simulation;

import org.simulation.model.entity.Entity;
import org.simulation.service.graph.entity.Coordinates;

import java.util.Collection;

public interface TargetIdentifier {
    Coordinates getClosest(Coordinates from, Collection<? extends Entity> entities, Class<?>... targetClasses);
}
