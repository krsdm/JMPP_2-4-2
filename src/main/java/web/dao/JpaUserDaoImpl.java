package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class JpaUserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByName(String userName) {
        return entityManager.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", userName)
                .getSingleResult();
    }
}
