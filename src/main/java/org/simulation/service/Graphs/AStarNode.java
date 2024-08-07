package org.simulation.service.Graphs;

import java.util.HashMap;

//public class AStarNode extends DijkstraNode{
public class AStarNode extends Node<String>{

    private int cost;
    private double heuristic;
    private double priority;

    HashMap<String, AStarNode> neighbours = new HashMap<>();

    public AStarNode(String id, Coordinates coordinates, int cost) {
        this.id = id;
        this.coordinates = coordinates;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void addNeighbour(AStarNode neighbour) {
        neighbours.put(neighbour.getId(), neighbour);
    }

    public HashMap<String, AStarNode> getNeighbours()
    {
        return neighbours;
    }

    @Override
    public String toString() {
        return super.toString() +
                "{" +
                ", heuristic=" + heuristic +
                ", priority=" + priority +
                '}';
    }
}
