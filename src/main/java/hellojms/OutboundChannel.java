package hellojms;


import javax.annotation.Resource;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

@Named (value = "outboundchannel")
@RequestScoped
public class OutboundChannel {

    @Resource(mappedName = "jms/__defaultConnectionFactory")
    private  ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/LabQueue")
    private  Queue queue;

    @Inject
    JmsStorage jmsStorage;

    public String postString;

    public void setPostString(String s) {
        postString = s;

        //jmsStorage.putString(s);
        post(s);


    }
    public String getPostString() {
        return postString;
    }

    private void post(String s) {
        JMSContext jmsContext = connectionFactory.createContext();
        JMSProducer jmsProducer = jmsContext.createProducer();
        jmsProducer.send(queue, s);
    }

}
