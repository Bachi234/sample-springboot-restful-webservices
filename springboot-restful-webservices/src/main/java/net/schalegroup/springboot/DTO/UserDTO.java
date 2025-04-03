package net.schalegroup.springboot.DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        description = "UserDTO Model Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO { //Data Transfer Object - fit for getting values directly from endpt/postman
    private Long id;
    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "Field should not be empty.")//fName could not be empty
    private String fName;
    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "Field should not be empty.")//lName could not be empty
    private String lName;
    @Schema(
            description = "User Email ADD"
    )
    @Email(message = "Email address is not valid.")
    @NotEmpty(message = "Field should not be empty.")//email could not be empty and should be a valid email address.
    private String email;
}
