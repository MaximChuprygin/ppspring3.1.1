package preproject312.preproject312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import preproject312.preproject312.models.User;


import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    //@Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
    //@Transactional
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    //@Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    //@Transactional
    public void update(Long id, User updateduser) {
        entityManager.merge(updateduser);
        entityManager.flush();

    }

    //@Transactional
    public void delete(Long id) throws NullPointerException {
        User user = findUserById(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
    }

}
