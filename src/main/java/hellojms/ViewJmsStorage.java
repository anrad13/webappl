package hellojms;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named (value = "viewjmsstorage")
@RequestScoped
public class ViewJmsStorage  implements Serializable {



    public String getStorage() {
        return "just text";
    }

}
