package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoleStoreTest {
    @Test
    void whenAddAndFindThen192168066() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin", "192.168.0.66"));
        Role result = store.findById("1");
        assertThat(result.getIp()).isEqualTo("192.168.0.66");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "User", "192.168.22.66"));
        Role result = store.findById("5");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin", "192.168.0.66"));
        store.add(new Role("1", "User", "192.168.22.66"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
        assertThat(result.getIp()).isEqualTo("192.168.0.66");
    }

    @Test
    void whenReplaceThenRoleUser() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin", "192.168.0.66"));
        store.replace("1", new Role("1", "User", "192.168.22.66"));
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("User");
    }

    @Test
    void whenNoDeleteRoleThenRoleAdmin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin", "192.168.0.66"));
        store.delete("5");
        Role result = store.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Admin", "192.168.0.66"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }
}