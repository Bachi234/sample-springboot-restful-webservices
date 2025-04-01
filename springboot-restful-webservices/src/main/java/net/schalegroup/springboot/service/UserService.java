package net.schalegroup.springboot.service;
import net.schalegroup.springboot.DTO.UserDTO;
import net.schalegroup.springboot.entity.User;
import java.util.List;
public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
}
