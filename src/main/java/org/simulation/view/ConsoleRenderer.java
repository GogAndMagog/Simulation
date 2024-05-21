package org.simulation.view;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.WorldMap;

import javax.annotation.processing.SupportedSourceVersion;

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
                } else if (worldMap.getCreatures().get(currentPosition) != null) {
                    sb.append(worldMap.getCreatures().get(currentPosition).getIcon());
                } else {
                    sb.append(BLANK).append(BLANK);
                }
            }
            sb.append(System.lineSeparator());
        }

        System.out.print(sb);
    }
}
