package hu.dpc.edu.controllerimpl;

import hu.dpc.edu.MessageController;
import hu.dpc.edu.MessageModel;
import hu.dpc.edu.MessageView;
import hu.dpc.edu.viewimpl.SwingView;
import org.springframework.beans.factory.BeanFactory;

import javax.inject.Provider;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class DefaultMessageController implements MessageController {

    private MessageModel model;
    private Provider<MessageView> viewProvider;

    public DefaultMessageController(MessageModel model, Provider<MessageView> viewProvider) {
        this.model = model;
        this.viewProvider = viewProvider;
    }

    @Override
    public void handleSave(String message) {
        model.setMessage(message);
    }

    @Override
    public void handleNewView() {
        MessageView view = viewProvider.get();
        view.setVisible();
    }
}
