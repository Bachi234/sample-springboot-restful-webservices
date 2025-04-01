package net.schalegroup.springboot.service.impl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.schalegroup.springboot.DTO.UserDTO;
import net.schalegroup.springboot.entity.User;
//import net.schalegroup.springboot.mapper.UserMapper;
import net.schalegroup.springboot.repository.UserRepo;
import net.schalegroup.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//implements UserService interface = impl
//Spring 4.3 onwards, whenever there is a Spring Bean, it has a single parametrized constructor which allows to omit @Autowired
@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepo userRepo; //used constructor based dependency injection to inject UserRepo into UserServiceImpl
    private ModelMapper modelMapper; //spring will automatically inject the dependency whenever it has a spring bean, it only has paramaterized constructor
    @Override
    public UserDTO createUser(UserDTO userDTO) {//dito binibridge yung userDTO and User
        // Convert UserDto into User JPA Entity
        //User user = UserMapper.mapToUser(userDTO);
        User user = modelMapper.map(userDTO,User.class);
        User savedUser = userRepo.save(user);
        //UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);
        UserDTO savedUserDTO = modelMapper.map(savedUser,UserDTO.class);
        return savedUserDTO;
    }
    @Override
    public UserDTO getUserById(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        User user =  optionalUser.get();
        //return UserMapper.mapToUserDTO(user); //convert User entity(JPA) into UserDTO
        return modelMapper.map(user,UserDTO.class);
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
//        return users.stream().map(UserMapper::mapToUserDTO)
//                .collect(Collectors.toList());
        return users.stream().map((user)->modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepo.findById(user.getId()).get();
        existingUser.setFName(user.getFName());
        existingUser.setLName(user.getLName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepo.save(existingUser);
//        return UserMapper.mapToUserDTO(updatedUser);
          return modelMapper.map(updatedUser,UserDTO.class);
    }
    @Override
    public void deleteUser(Long userId){
        userRepo.deleteById(userId);
    }
}

