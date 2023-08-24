package preproject312.preproject312.dao;

import org.springframework.transaction.annotation.Transactional;
import preproject312.preproject312.models.User;


import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public User findUserById(Long id);

    public void saveUser(User user);

    public void update(Long id, User updateduser);

    @Transactional
    public void delete(Long id);
}
