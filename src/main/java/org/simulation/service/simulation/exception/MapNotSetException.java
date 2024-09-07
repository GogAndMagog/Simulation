package org.simulation.service.simulation.exception;

public class MapNotSetException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Карта не выбрана";
    }
}
