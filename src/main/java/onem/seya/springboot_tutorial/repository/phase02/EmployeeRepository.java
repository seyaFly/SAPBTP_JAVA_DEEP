package onem.seya.springboot_tutorial.repository.phase02;

import onem.seya.springboot_tutorial.models.phase02.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
