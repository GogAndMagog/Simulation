package org.simulation.model.entities.searchstructs;

import org.simulation.model.coordinates.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final Coordinates position;
    private int passability;

    private boolean visited = false;
    private Node parent;
    private List<Node> children = new ArrayList<>();

    public Node(Coordinates position, int passability) {
        this.position = position;
        this.passability = passability;
    }

    public Node(Coordinates position, Node parent, List<Node> children, int passability) {
        this.position = position;
        this.parent = parent;
        this.passability = passability;
    }

    public Node setVisited(boolean visited) {
        this.visited = visited;
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public Node setParent(Node parent) {
        this.parent = parent;
        return this;
    }

    public Node setChildren(List<Node> children) {
        this.children.addAll(children);
        return this;
    }

    public Coordinates getPosition() {
        return position;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public int getPassability() {
        return passability;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Node{")
                .append("position=").append(position)
                .append(", passability=").append(passability)
                .append(", visited=").append(visited)
                .append(", parent=").append(parent)
                .append(", children={");

        children.forEach(child -> str.append(child.getPosition()));
        str.append("}}");

        return str.toString();
    }
}
