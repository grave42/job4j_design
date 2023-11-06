package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;


@XmlRootElement(name = "intercom2")
@XmlAccessorType(XmlAccessType.FIELD)
public class Intercom2 {
    @XmlAttribute
    private boolean call;

    @XmlAttribute
    private int id;

    @XmlAttribute
    private String model;
    private HwFw2 hwFw;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Intercom2() { }

    public Intercom2(int id, String model, boolean call, HwFw2 hwFw, String[] statuses) {
        this.call = call;
        this.id = id;
        this.model = model;
        this.hwFw = hwFw;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Intercom2{"
                + "id=" + id
                + ", model=" + model
                + ", call=" + call
                + ", HwFw=" + hwFw
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
