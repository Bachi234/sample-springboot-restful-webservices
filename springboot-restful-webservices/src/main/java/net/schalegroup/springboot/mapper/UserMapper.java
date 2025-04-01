package net.schalegroup.springboot.mapper;
import net.schalegroup.springboot.DTO.UserDTO;
import net.schalegroup.springboot.entity.User;

public class UserMapper {
    //Convert JPA Entity into UserDTO
    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFName(),
                user.getLName(),
                user.getEmail()
        );
        return userDTO;
    }
    //Convert UserDTO into User JPA Entity
    public static User mapToUser(UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getFName(),
                userDTO.getLName(),
                userDTO.getEmail()
        );
        return user;
    }
}
