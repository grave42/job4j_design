package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hwfw2")
public class HwFw2 {

    @XmlAttribute
    private String hw;

    @XmlAttribute
    private String fw;

    public HwFw2() { }

    public HwFw2(String hw, String  fw) {
        this.hw = hw;
        this.fw = fw;
    }

    @Override
    public String toString() {
        return "HwFw{"
                + "hw='" + hw + '\''
                + ", fw='" + fw + '\''
                + '}';
    }
}