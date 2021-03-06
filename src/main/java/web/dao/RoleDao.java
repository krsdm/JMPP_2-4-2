package web.dao;

import web.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRoles();
    void remove(Role role);
    Role getByName(String name);
    void saveRole(Role role);
    Role getById(Long id);
}
