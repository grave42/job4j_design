package ru.job4j.serialization.json;

import java.util.Arrays;

public class Intercom {
    private final boolean call;
    private final int id;

    private final String model;
    private final HwFw hwFw;
    private final String[] statuses;

    public Intercom(int id, String model, boolean call, HwFw hwFw, String[] statuses) {
        this.call = call;
        this.id = id;
        this.model = model;
        this.hwFw = hwFw;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Intercom{"
                + "id=" + id
                + ", model=" + model
                + ", call=" + call
                + ", HwFw=" + hwFw
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public boolean isCall() {
        return call;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public HwFw getHwFw() {
        return hwFw;
    }

    public String[] getStatuses() {
        return statuses;
    }
}
