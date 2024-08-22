package org.simulation.view;

import org.simulation.model.entities.Icons;
import org.simulation.model.entities.WorldMap;
import org.simulation.model.entities.dynamic.carnivore.Wolf;
import org.simulation.model.entities.dynamic.herbivore.Sheep;
import org.simulation.model.entities.statical.terrain.Herb;
import org.simulation.model.entities.statical.terrain.Road;
import org.simulation.model.entities.statical.terrain.Sand;
import org.simulation.service.Graphs.Entities.Coordinates;

public class ConsoleRenderer implements Renderer {

    private static final String BLANK = " ";
    private static final String TAB = "\t";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) {

        String WOLF = "\uD83D\uDC3A";
        String LAMB = "\uD83D\uDC11";
        String MOUNTAIN = "\u26F0\uFE0F";
        String SNOW_MOUNTAIN = "\uD83C\uDFD4\uFE0F";
        String HERB = "\uD83C\uDF3F";
        String GREEN_SQUARE = "\uD83D\uDFE9";
        String TREE = "\uD83C\uDF33";
        StringBuilder sb = new StringBuilder();

        WorldMap worldMap = new WorldMap(3, 3);
        Renderer renderer = new ConsoleRenderer(worldMap);

        worldMap.setCreature(new Wolf(new Coordinates(0, 0), worldMap,10,10, 10));
        worldMap.setCreature(new Wolf(new Coordinates(1, 0), worldMap, 10, 10, 10));
        worldMap.setCreature(new Wolf(new Coordinates(0, 1), worldMap, 10, 10, 10));
        worldMap.setCreature(new Sheep(new Coordinates(1, 1), worldMap, 10, 10));
        worldMap.setCreature(new Sheep(new Coordinates(2, 2), worldMap, 10, 10));
        worldMap.setLandscapeObject(new Sand(new Coordinates(0,0)));
        worldMap.setLandscapeObject(new Sand(new Coordinates(1,0)));
        worldMap.setLandscapeObject(new Herb(new Coordinates(0,1)));
        worldMap.setLandscapeObject(new Road(new Coordinates(1,1)));
        worldMap.setLandscapeObject(new Road(new Coordinates(2,1)));


        renderer.render();

    }

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
