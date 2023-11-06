package ru.job4j.serialization.json;

public class HwFw {
    private final String hw;

    private final String fw;

    public HwFw(String hw, String  fw) {
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

    public String getHw() {
        return hw;
    }

    public String getFw() {
        return fw;
    }
}