package hu.dpc.edu.components.repoimpl;

import hu.dpc.edu.MessageChangeListener;
import hu.dpc.edu.MessageChangedEvent;
import hu.dpc.edu.MessageModel;
import hu.dpc.edu.spring.Fake;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by vrg on 2016. 11. 08..
 */
@Component
@Fake
public class FakeMessageModel implements MessageModel {

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void setMessage(String newMessage) {
    }

    @Override
    public void addMessageChangeListener(MessageChangeListener listener) {

    }

    @Override
    public void removeMessageChangeListener(MessageChangeListener listener) {
    }
}
