package hellojms;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/LabQueue")
public class InboundChannel implements MessageListener {

    @Inject
    JmsStorage jmsStorage;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try
        {
            jmsStorage.putString(textMessage.getText());
        }
        catch (JMSException e)
        {
            jmsStorage.putString("JMSException!!! " + e.toString());
        }
    }
}
