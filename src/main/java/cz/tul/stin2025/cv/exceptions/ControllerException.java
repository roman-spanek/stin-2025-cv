package cz.tul.stin2025.cv.exceptions;

public class ControllerException extends RuntimeException {
    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable e) {
        super(message, e);
    }
}
