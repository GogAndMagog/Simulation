package org.simulation.view;

import org.simulation.model.entity.Icons;
import org.simulation.model.entity.WorldMap;
import org.simulation.model.entity.statical.terrain.Terrain;
import org.simulation.service.graph.entity.Coordinates;

public class ConsoleRenderer implements Renderer {

    WorldMap worldMap;

    public ConsoleRenderer(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public void render() {
        StringBuilder sb = new StringBuilder();
        Coordinates currentPosition;

        sb.append("##".repeat(worldMap.getX()));
        sb.append(System.lineSeparator());

        for (int i = 0; i < worldMap.getY(); i++) {
            for (int j = 0; j < worldMap.getX(); j++) {
                currentPosition = new Coordinates(j, i);

                if (worldMap.getLandscape().get(currentPosition) != null) {
                    sb.append(worldMap.getLandscape().get(currentPosition).getIcon());

                    if (!(worldMap.getLandscape().get(currentPosition) instanceof Terrain)) {
                        continue;
                    }
                }
                if (worldMap.getCreatures().get(currentPosition) != null) {
                    sb.append(worldMap.getCreatures().get(currentPosition).getIcon());
                } else {
                    sb.append(Icons.BLANK).append(Icons.BLANK);
                }
                sb.append(Icons.ANSI_RESET);
            }
            sb.append(System.lineSeparator());
        }

        System.out.print(sb);
    }
}
