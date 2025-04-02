package net.schalegroup.springboot.repository;
import net.schalegroup.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository<[Type of the JPA Entity], [Type of the Primary Key]>
public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
