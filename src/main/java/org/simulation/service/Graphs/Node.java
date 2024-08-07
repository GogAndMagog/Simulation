package org.simulation.service.Graphs;

public abstract class Node<Id> {
    protected Id id;
    protected Coordinates coordinates;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
