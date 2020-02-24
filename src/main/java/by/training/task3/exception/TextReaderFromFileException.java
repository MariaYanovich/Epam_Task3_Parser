package by.training.task3.exception;

public class TextReaderFromFileException extends Exception {
    public TextReaderFromFileException() {
        super();
    }

    public TextReaderFromFileException(String message) {
        super(message);
    }

    public TextReaderFromFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextReaderFromFileException(Throwable cause) {
        super(cause);
    }

    protected TextReaderFromFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
