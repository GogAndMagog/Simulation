package org.simulation.model.entities.searchstructs;

import org.simulation.model.entities.statical.terrain.Terrain;

import java.util.List;

public class Path {
    List<Node> path;

    public Path() {}

    public void add(Node node) { path.add(node); }

    public List<Node> getPath() { return path; }

    public int getLength() {
        int length = 0;
        for (Node node : path) {
            length++;
            if (node instanceof Terrain) {
                length += node.getPassability();
            }
        }
        return length;
    }
}
