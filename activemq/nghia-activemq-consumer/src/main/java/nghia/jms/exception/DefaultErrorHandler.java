package nghia.jms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class DefaultErrorHandler extends RuntimeException implements ErrorHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void handleError(Throwable t) {
        log.warn("spring jms custom error handling example");
        log.error("ERROR\n{}", t.getCause());
    }

    public DefaultErrorHandler() {
    }

    public DefaultErrorHandler(String message) {
        super(message);
    }

    public DefaultErrorHandler(String message, Throwable cause) {
        super(message, cause);
    }
}
