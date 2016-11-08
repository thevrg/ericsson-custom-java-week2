package hu.dpc.edu.spring;

import hu.dpc.edu.MessageController;
import hu.dpc.edu.MessageModel;
import hu.dpc.edu.MessageView;
import hu.dpc.edu.components.repoimpl.FakeMessageModel;
import hu.dpc.edu.controllerimpl.DefaultMessageController;
import hu.dpc.edu.repoimpl.InMemoryMessageModel;
import hu.dpc.edu.viewimpl.SwingView;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

/**
 * Created by vrg on 2016. 11. 08..
 */
@Configuration
@ComponentScan("hu.dpc.edu.components.repoimpl")
public class MessageApplicationConfig {


//    @Bean
//    public MyBeanPostProcessor postProcessor() {
//        return new MyBeanPostProcessor();
//    }

    @Bean
    @InMemory
    public MessageModel messageModel() {
        return new InMemoryMessageModel();
    }

    @Bean
    public MessageController controller(@InMemory MessageModel model, Provider<MessageView> viewProvider) {
        System.out.println(model.getClass());
        return new DefaultMessageController(model, viewProvider);
    }

    @Bean
    @Scope("prototype")

    public MessageView view(@InMemory MessageModel model, MessageController controller) {
        return new SwingView(model, controller);
    }
}
