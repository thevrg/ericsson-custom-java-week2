package hu.dpc.edu.viewimpl;

import hu.dpc.edu.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class SwingView implements MessageView, MessageChangeListener {
    private JFrame frame;
    private JButton saveButton;
    private JButton newViewButton;
    private JTextField messageTextField;
    private MessageModel model;
    private MessageController controller;



    public SwingView(MessageModel model, MessageController controller) {
        this.model = model;
        this.controller = controller;
        this.frame = new JFrame("Message View");
        this.saveButton = new JButton("Save");
        this.newViewButton = new JButton("New View");
        this.messageTextField = new JTextField();
        messageTextField.setPreferredSize(new Dimension(130,20));
        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(messageTextField);
        contentPane.add(saveButton);
        contentPane.add(newViewButton);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        saveButton.addActionListener((event) -> controller.handleSave(messageTextField.getText()));
        newViewButton.addActionListener((event) -> controller.handleNewView());


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                model.removeMessageChangeListener(SwingView.this);
            }
        });

    }

    @PostConstruct
    void initView() {
        model.addMessageChangeListener(this);
    }

    @PreDestroy
    void stopView() {
        model.removeMessageChangeListener(this);
    }

    @Override
    public void setVisible() {
        EventQueue.invokeLater(()-> frame.setVisible(true));
    }

    @Override
    public void handleMessageChanged(MessageChangedEvent event) {
        messageTextField.setText(event.getNewMessage());
    }
}
