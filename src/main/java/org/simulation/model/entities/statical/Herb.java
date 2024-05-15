package org.simulation.model.entities.statical;

import org.simulation.model.coordinates.*;
import org.simulation.model.entities.WorldMap;

public class Herb extends LandscapeObject {

    private static final String BLANK = " ";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_RESET = "\u001B[0m";
    private final String ICON = ANSI_GREEN_BACKGROUND + BLANK + BLANK + ANSI_RESET;
//    private final String ICON = ANSI_GREEN_BACKGROUND + "\uD83C\uDF3F" + ANSI_RESET;

    public Herb(Coordinates position) {
        super(position);
    }
    public Herb(Coordinates position, WorldMap worldMap) {
        super(position, worldMap);
    }
    @Override
    public String getIcon() {
        return ICON;
    }
}
