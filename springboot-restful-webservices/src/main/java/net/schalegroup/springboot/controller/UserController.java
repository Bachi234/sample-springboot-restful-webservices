package net.schalegroup.springboot.controller;
import lombok.AllArgsConstructor;
import net.schalegroup.springboot.DTO.userDTO;
import net.schalegroup.springboot.entity.User;
import net.schalegroup.springboot.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//build create User REST API
//RequestBody will convert JSON into User Java Object
//entity = papunta lang sa db yung purpose
//Initial values galing sa postman/endpoint
//store value = user has value. Java sometimes is whack in terms of its behavoir kasi bat may directly tumatawag sa entity.
// D alam kung san mag instantiate...? Kaya null napupulot
//Hindi dapat directly tinatawg yung entity class pag nagca-call ng endpt/postman (get/setmapping)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody userDTO userDTO) {
        User savedUser = userService.createUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    //build get user by REST API
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //build get ALL user REST API
    //http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
       List<User> users = userService.getAllUsers();
       return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //build UPDATE USER REST API
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")//to map put request onto specific handler method
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){ //RequestBody is for JSON User into Java Object
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    //build DELETE USER REST API
    //http://localhost:8080/api/users/1
    @DeleteMapping("{id}") //map incoming delete requests onto specific handler method
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
//    public ResponseEntity<User> getUserById(@PathVariable ("id") Long userId) {
//        User user = userService.getUserById(userId);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }


