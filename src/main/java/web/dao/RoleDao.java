package web.dao;

import web.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRolse();
    void remove(Role role);
    Role getByName(String name);
}
