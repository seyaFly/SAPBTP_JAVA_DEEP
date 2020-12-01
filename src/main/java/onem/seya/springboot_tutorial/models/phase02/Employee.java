package onem.seya.springboot_tutorial.models.phase02;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "T_EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee implements Serializable {
    @Id
    @Column(name ="Id", unique=true)
    private long id;

    @Column(name ="firstName")
    private String firstName;
    @Column(name ="lastName")
    private String lastName;
    @Column(name ="email", unique=true)
    private String email;
    @Column(name ="contact",unique=true)
    private String contact;
}
