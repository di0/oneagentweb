package develdio.com.oneagentweb.dao;

import develdio.com.oneagentweb.dao.generic.TemplateAbstractDAO;
import develdio.com.oneagentweb.plataform.ObjectFactory;
import develdio.com.oneagentweb.plataform.OneAgentWebService01;

public class ClientDataDao extends TemplateAbstractDAO {
    public OneAgentWebService01 fetchDataByPhoneNumber(final String phoneNumber) {
        OneAgentWebService01 oneAgentServiceCasted = null;

        try {
            final ObjectFactory o = new ObjectFactory();
            final OneAgentWebService01 serviceOaw = o.createOneAgentWebService01();
            final OneAgentWebService01.Input inputOaw = o.createOneAgentWebService01Input();
            serviceOaw.setInput(inputOaw);

            inputOaw.setUser("Foo");
            inputOaw.setPhone(phoneNumber);
            inputOaw.setTypeTest("Just testing");

            // Putting message into Camel route.
            oneAgentServiceCasted = (OneAgentWebService01) template
                    .requestBody("direct:oaw", serviceOaw);
        } catch (final Exception e) {
            System.out.println("Camel Fatal Error?: " + e.getMessage());
        }

        return oneAgentServiceCasted;
    }
}
