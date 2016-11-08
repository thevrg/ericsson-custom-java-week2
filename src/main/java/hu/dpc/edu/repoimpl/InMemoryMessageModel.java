package hu.dpc.edu.repoimpl;

import hu.dpc.edu.MessageChangeListener;
import hu.dpc.edu.MessageChangedEvent;
import hu.dpc.edu.MessageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class InMemoryMessageModel implements MessageModel {

    private String message;
    private List<MessageChangeListener>messageChangeListeners = new ArrayList<>();

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String newMessage) {
        if (!Objects.equals(message,newMessage)) {
            final MessageChangedEvent event = new MessageChangedEvent(this, this.message, newMessage);
            this.message = newMessage;

            fireMessageChangedEvent(event);
        }
    }

    void fireMessageChangedEvent(MessageChangedEvent event) {
        messageChangeListeners.forEach(listener ->  listener.handleMessageChanged(event));
    }

    @Override
    public void addMessageChangeListener(MessageChangeListener listener) {
        messageChangeListeners.add(listener);
    }

    @Override
    public void removeMessageChangeListener(MessageChangeListener listener) {
        messageChangeListeners.remove(listener);
    }
}
