package hu.dpc.edu.viewimpl;

import hu.dpc.edu.MessageView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vrg on 2016. 11. 08..
 */
public class SwingView implements MessageView {
    private JFrame frame;
    private JButton saveButton;
    private JTextField messageTextField;

    public SwingView() {
        this.frame = new JFrame("Message View");
        this.saveButton = new JButton("Save");
        this.messageTextField = new JTextField();
        messageTextField.setPreferredSize(new Dimension(130,20));
        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(messageTextField);
        contentPane.add(saveButton);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void setVisible() {
        EventQueue.invokeLater(()-> frame.setVisible(true));
    }

    public static void main(String[] args) {
        new SwingView().setVisible();
    }

}
