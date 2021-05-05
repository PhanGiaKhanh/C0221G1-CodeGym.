package library.commons;

import javax.annotation.processing.Messager;

public class MessageException extends Exception {
    public MessageException() {
        super();
    }

    public MessageException(String message) {
        super(message);
    }
}
