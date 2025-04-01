package net.schalegroup.springboot.service;
import net.schalegroup.springboot.DTO.userDTO;
import net.schalegroup.springboot.entity.User;
import java.util.List;
public interface UserService {
    User createUser(userDTO userDTO);
    User getUserById(Long userId);
    List <User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
}
