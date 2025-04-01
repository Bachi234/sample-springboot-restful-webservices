package net.schalegroup.springboot.repository;
import net.schalegroup.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository<[Type of the JPA Entity], [Type of the Primary Key]>
public interface UserRepo extends JpaRepository<User, Long>{}
