package preproject312.preproject312.service;



import preproject312.preproject312.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User findUserById(Long id);

    public void saveUser(User user);

    public void update(Long id, User updateduser);

    public void delete(Long id);
}
