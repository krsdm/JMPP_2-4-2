package web.service;

import web.models.Role;
import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void saveUser(User user);
    void updateUser(User updatedUser);
    void removeUser(long id);
    User getUserByName(String userName);

    List<Role> getRoles();
    void remove(Role role);
    void saveRole(Role role);
    Role getRoleById(Long id);
    Role getByName(String name);

}
