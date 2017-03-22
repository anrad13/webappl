package hellojms;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class JmsStorage {

    private List<String> strings = new ArrayList<>();

    @PostConstruct
    private void init() {
        strings.add("Initial auto generated string");
        strings.add("Initial auto generated string 2");
    }

    public String getString() {
        StringBuffer sb = new StringBuffer();
        //for (String s: strings) {            sb.append(s).append("\n");        }
        String s2 = strings.stream().collect(Collectors.joining(";\n "));
        //return sb.toString();

        return s2;
    }
}
