package nghia.jms.exception;

public class QueueException extends RuntimeException {
    public QueueException() {
    }

    public QueueException(String message) {
        super(message);
    }
}