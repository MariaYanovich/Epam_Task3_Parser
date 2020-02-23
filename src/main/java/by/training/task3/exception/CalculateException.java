package by.training.task3.exception;

public class CalculateException extends Exception {
    public CalculateException() {
        super();
    }

    public CalculateException(String message) {
        super(message);
    }

    public CalculateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculateException(Throwable cause) {
        super(cause);
    }

    protected CalculateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
