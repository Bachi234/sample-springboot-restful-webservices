package net.schalegroup.springboot.service.impl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.schalegroup.springboot.DTO.userDTO;
import net.schalegroup.springboot.entity.User;
import net.schalegroup.springboot.repository.UserRepo;
import net.schalegroup.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//implements UserService interface = impl
//Spring 4.3 onwards, whenever there is a Spring Bean, it has a single parametrized constructor which allows to omit @Autowired
@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private UserRepo userRepo; //used constructor based dependency injection to inject UserRepo into UserServiceImpl
    @Override
    public User createUser(userDTO userDTO) {//dito binibridge yung userDTO and User
        User user = new User();// instantiate nang new user obj
        user.setFName(userDTO.getFName());// yung mga sinet na values papuntang user object galing sa userDTO; conversion ng dto to db
        user.setLName(userDTO.getLName());
        user.setEmail(userDTO.getEmail());
        return userRepo.save(user); //saving part happens here kung ano man yung nakalagay ng object sa loob ng ().
    }
    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        return optionalUser.get();
    }
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    @Override
    public User updateUser(User user) {
        User existingUser = userRepo.findById(user.getId()).get();
        existingUser.setFName(user.getFName());
        existingUser.setLName(user.getLName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepo.save(existingUser);
        return updatedUser;
    }
    @Override
    public void deleteUser(Long userId){
        userRepo.deleteById(userId);
    }
}

