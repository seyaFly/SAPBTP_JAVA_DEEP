package onem.seya.springboot_tutorial.models.phase02;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "T_EMPLOYEE")
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

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
