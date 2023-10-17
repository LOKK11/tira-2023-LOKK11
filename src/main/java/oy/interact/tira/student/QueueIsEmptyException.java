package oy.interact.tira.student;

public class QueueIsEmptyException extends IllegalStateException {
    public QueueIsEmptyException(String message) {
        super(message);
    }
}
