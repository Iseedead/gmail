package Util.TestCheck;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "checks")
@XmlAccessorType(XmlAccessType.FIELD)
class Checks {

    @XmlElement(name = "check")
    private List<Check> checks = null;

    List<Check> getChecks() {
        return checks;
    }

    void setChecks(List<Check> checks) {
        this.checks = checks;
    }
}