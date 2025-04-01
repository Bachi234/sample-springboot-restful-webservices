package net.schalegroup.springboot.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="f_name", nullable = false)
    private String fName;
    @Column(name ="l_name", nullable = false)
    private String lName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}