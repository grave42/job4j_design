package ru.job4j.generics;

public class Role extends Base {

    private final String rolename;
    private final String ip;

    public Role(String id, String rolename, String ip) {
        super(id);
        this.rolename = rolename;
        this.ip = ip;
    }

    public String getRole() {
        return rolename;
    }

    public String getIp() {
        return ip;
    }
}