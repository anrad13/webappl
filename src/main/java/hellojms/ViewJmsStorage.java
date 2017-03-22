package hellojms;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named (value = "viewjmsstorage")
@RequestScoped
public class ViewJmsStorage  implements Serializable {

    @Inject
    JmsStorage jmsStorage;

    public String getStorage() {
        StringBuffer sb = new StringBuffer("This is jms viewer;\n ")
                .append(jmsStorage.getString())
                .append("END\n");

        return sb.toString();
    }

}
