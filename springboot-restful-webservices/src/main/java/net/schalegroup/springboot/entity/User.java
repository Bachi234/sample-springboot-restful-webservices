package net.schalegroup.springboot.entity;
import jakarta.persistence.*;
import lombok.*;
//JPA provides four primary key generations: auto, identity, table and sequence
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//getting values directly from db
@Data
@Entity //specifies that the class is a JPA entity.
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this identity is the primary generation strategy internal uses db provided auto-increment to incre the primary key
    private Long id;
    @Column(name = "f_name", nullable = false)
    private String fName;
    @Column(name = "l_name", nullable = false)
    private String lName;
    @Column(name = "email",unique = true)
    private String email;
}
