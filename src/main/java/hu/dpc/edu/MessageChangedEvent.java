package hu.dpc.edu;

import java.util.EventObject;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class MessageChangedEvent extends EventObject {

    private final String oldMessage;
    private final String newMessage;

    public MessageChangedEvent(Object source, String oldMessage, String newMessage) {
        super(source);
        this.oldMessage = oldMessage;
        this.newMessage = newMessage;
    }

    public String getOldMessage() {
        return oldMessage;
    }

    public String getNewMessage() {
        return newMessage;
    }
}
