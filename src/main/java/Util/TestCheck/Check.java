package Util.TestCheck;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "check")
public class Check {
    private String actual;
    private String expected;
    private String testname;

    public String getActual() {
        return actual;
    }

    @XmlElement(name = "actual")
    void setActual(String actual) {
        this.actual = actual;
    }

    public String getExpected() {
        return expected;
    }

    @XmlElement(name = "expected")
    void setExpected(String expected) {
        this.expected = expected;
    }

    public String getTestname() {
        return testname;
    }

    @XmlAttribute(name = "testname")
    void setTestname(String testname) {
        this.testname = testname;
    }
}