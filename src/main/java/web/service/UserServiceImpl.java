package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.models.Role;
import web.models.User;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        userDao.updateUser(updatedUser);
    }

    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    public User getUserByName(String userName) {
        User user;
        try {
            user = userDao.getUserByName(userName);
        } catch (NoResultException e) {
            return null;
        }
        return user;
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public void remove(Role role) {
        roleDao.remove(role);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }

}
