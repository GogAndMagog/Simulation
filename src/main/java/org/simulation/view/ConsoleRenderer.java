package org.simulation.view;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.WorldMap;

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

        sb.append(ANSI_GREEN_BACKGROUND)
                .append(WOLF)
                .append(ANSI_RESET)
                .append(MOUNTAIN)
                .append(ANSI_GREEN_BACKGROUND)
                .append(LAMB)
                .append(ANSI_RESET)
                .append(SNOW_MOUNTAIN)
                .append(ANSI_GREEN_BACKGROUND)
                .append(WOLF)
                .append(WOLF)
                .append(ANSI_RESET);
        System.out.println(sb.toString());

        sb.setLength(0);
        sb.append(SNOW_MOUNTAIN)
                .append(SNOW_MOUNTAIN)
                .append(SNOW_MOUNTAIN)
                .append(SNOW_MOUNTAIN)
                .append(SNOW_MOUNTAIN)
                .append(SNOW_MOUNTAIN);
        System.out.println(sb.toString());

        sb.setLength(0);
        sb.append(ANSI_GREEN_BACKGROUND)
                .append(HERB)
                .append(HERB)
                .append(HERB)
                .append(HERB)
                .append(HERB)
                .append(HERB)
                .append(ANSI_RESET);
        System.out.println(sb.toString());

        sb.setLength(0);
        sb.
//                append(ANSI_GREEN_BACKGROUND)
        append(TREE)
                .append(TREE)
                .append(TREE)
                .append(TREE)
                .append(TREE)
                .append(TREE);
//                .append(ANSI_RESET);
        System.out.println(sb.toString());

        sb.setLength(0);
        sb.
//                append(ANSI_GREEN_BACKGROUND)
        append(GREEN_SQUARE)
                .append(GREEN_SQUARE)
                .append(GREEN_SQUARE)
                .append(GREEN_SQUARE)
                .append(GREEN_SQUARE)
                .append(GREEN_SQUARE);
        System.out.println(sb.toString());

    }

    WorldMap worldMap;

    public ConsoleRenderer(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public void render() {
        StringBuilder sb = new StringBuilder();
        Coordinates currentPosition;

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

        System.out.print("\r" + sb.toString());
//        System.out.print(sb);
    }
}
