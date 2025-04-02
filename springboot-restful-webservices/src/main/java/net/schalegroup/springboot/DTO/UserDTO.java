package net.schalegroup.springboot.DTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO { //Data Transfer Object - fit for getting values directly from endpt/postman
    private Long id;
    @NotEmpty(message = "Field should not be empty.")//fName could not be empty
    private String fName;
    @NotEmpty(message = "Field should not be empty.")//lName could not be empty
    private String lName;
    @Email(message = "Email address is not valid.")
    @NotEmpty(message = "Field should not be empty.")//email could not be empty and should be a valid email address.
    private String email;

}
