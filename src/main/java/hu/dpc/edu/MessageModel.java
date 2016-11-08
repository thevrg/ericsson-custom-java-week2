package hu.dpc.edu;

/**
 * Created by vrg on 2016. 11. 08..
 */
public interface MessageModel {

    public String getMessage();
    public void setMessage(String message);

    public void addMessageChangeListener(MessageChangeListener listener);
    public void removeMessageChangeListener(MessageChangeListener listener);
}
