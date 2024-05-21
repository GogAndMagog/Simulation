package org.simulation.model.entities.dynamic.herbivore;

import org.simulation.model.coordinates.Coordinates;
import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;

public class Sheep extends Herbivore {

    public Sheep(Coordinates position, int speed, int hp) {
        super(position, speed, hp);
    }

    public Sheep(Coordinates position, WorldMap worldMap, int speed, int hp) {
        super(position, worldMap, speed, hp);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String getIcon() {
        return Icons.ICON_SHEEP;
    }
}
