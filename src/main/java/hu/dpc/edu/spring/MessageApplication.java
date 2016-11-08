package hu.dpc.edu.spring;

import hu.dpc.edu.MessageView;
import hu.dpc.edu.viewimpl.SwingView;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class MessageApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MessageApplicationConfig.class);

        final MessageView view1 = context.getBean(MessageView.class);
        final MessageView view2 = context.getBean(MessageView.class);

        view1.setVisible();
        view2.setVisible();
    }
}
