package net.schalegroup.springboot.DTO;
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
    private String fName;
    private String lName;
    private String email;
}
