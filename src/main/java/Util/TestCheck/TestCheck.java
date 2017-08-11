package Util.TestCheck;

import org.testng.Assert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class TestCheck {
    private static File file = new File("src/test/resources/check.xml");
    private static Checks checks = new Checks();

    static {
        checks.setChecks(new ArrayList<Check>());
    }

    public static void assertEquals(String actual, String expected) {
        switch (System.getProperty("testcheck")) {
            case "true": {
                String callerClassName = new Exception().getStackTrace()[1].getClassName();
                setter(actual, expected, callerClassName);
                marshaling();
                Assert.assertEquals(actual, expected);
                break;
            }
            case "false": {
                Assert.assertEquals(actual, expected);
            }
        }
    }

    private static void setter(String actual, String expected, String testname) {
        Check test = new Check();
        test.setActual(actual);
        test.setExpected(expected);
        test.setTestname(testname);
        checks.getChecks().add(test);
    }

    private static void marshaling() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Checks.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(checks, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}