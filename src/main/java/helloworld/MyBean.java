package helloworld;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named (value="helloworld")
@RequestScoped
public class MyBean implements Serializable {



    public String getHello() {
        return "Hello world from MyBean";
    }
}
