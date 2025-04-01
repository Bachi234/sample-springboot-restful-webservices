package net.schalegroup.springboot.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
public class userDTO { //Data Transfer Object - fit for getting values directly from endpt/postman
    Long id;
    String fName;
    String lName;
    String email;
}
