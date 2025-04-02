package net.schalegroup.springboot.mapper;
import net.schalegroup.springboot.DTO.UserDTO;
import net.schalegroup.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    //@Mapping(source = "email", target = "emailAddress")
    //MAPPER is used to call these mapping methods
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class); //provide the implementation for this interface at compilation time
    UserDTO mapToUserDTO(User user);
    User mapToUser(UserDTO userDTO);
}
