package net.schalegroup.springboot.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.schalegroup.springboot.DTO.UserDTO;
import net.schalegroup.springboot.entity.User;
import net.schalegroup.springboot.exception.ErrorDetails;
import net.schalegroup.springboot.exception.ResourceNotFoundException;
import net.schalegroup.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
import java.util.List;
//build create User REST API
//RequestBody will convert JSON into User Java Object
//entity = papunta lang sa db yung purpose
//Initial values galing sa postman/endpoint
//store value = user has value. Java sometimes is whack in terms of its behavoir kasi bat may directly tumatawag sa entity.
// D alam kung san mag instantiate...? Kaya null napupulot
//Hindi dapat directly tinatawg yung entity class pag nagca-call ng endpt/postman (get/setmapping)
@Tag(
        name = "CRUD REST APIs for SCHALE Resource",
        description = "CRUD REST APIs - Create, Update, Get Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class  UserController {
    private UserService userService;
    @Operation(
            summary = "Create a user via REST API",
            description = "Used to POST new user in the database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status: 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        UserDTO savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get user ID via REST API",
            description = "Used to fetch user in the database via ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status: 200 SUCCESS"
    )
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId) {
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @Operation(
            summary = "Get all users via REST API",
            description = "Used to fetch all users in the database via ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status: 200 SUCCESS"
    )
    //http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @Operation(
            summary = "Update user via REST API",
            description = "Used to update a single user in the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status: 200 SUCCESS"
    )
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")//to map put request onto specific handler method
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody @Valid UserDTO user){ //RequestBody is for JSON User into Java Object
        user.setId(userId);
        UserDTO updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @Operation(
            summary = "Delete user using REST API",
            description = "Delete REST API is used to delete a user from the DB."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status: 200 SUCCESS"
    )
    //http://localhost:8080/api/users/1
    @DeleteMapping("{id}") //map incoming delete requests onto specific handler method
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
//    @ExceptionHandler(ResourceNotFoundException.class)//used to handle specific exceptions and send a custom response to client
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}



