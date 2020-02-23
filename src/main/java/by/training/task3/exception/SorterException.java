package by.training.task3.exception;

public class SorterException extends Exception {
    public SorterException() {
        super();
    }

    public SorterException(String message) {
        super(message);
    }

    public SorterException(String message, Throwable cause) {
        super(message, cause);
    }

    public SorterException(Throwable cause) {
        super(cause);
    }

    protected SorterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
