package library.commons;

import javax.annotation.processing.Messager;

public class MessageException extends Exception {
    public MessageException(String message) {
        super(message);
    }
}
