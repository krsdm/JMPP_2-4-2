package web.servise;

import web.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolse();
    void remove(Role role);
}
