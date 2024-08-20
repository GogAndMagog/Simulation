package org.simulation.service.Graphs.Entities;

import java.util.HashMap;

public class DijkstraNode extends Node<String> implements Comparable<DijkstraNode> {

    private Coordinates coordinates;
    private int cost;
    DijkstraNode parent;

    HashMap<String, DijkstraNode> neighbours = new HashMap<>();

    public DijkstraNode(String id, Coordinates coordinates, int cost) {
        this.coordinates = coordinates;
        this.id = id;
        this.cost = cost;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public HashMap<String, DijkstraNode> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(DijkstraNode neighbour) {
        neighbours.put(neighbour.getId(), neighbour);
    }

    public DijkstraNode getParent() {
        return parent;
    }

    public void setParent(DijkstraNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "coordinates=" + coordinates +
                ", id=" + id +
                ", cost=" + cost +
                ", parent=" + parent +
                '}';
    }

    @Override
    public int compareTo(DijkstraNode o) {
        return Integer.compare(this.getCost(), o.getCost());
    }
}
