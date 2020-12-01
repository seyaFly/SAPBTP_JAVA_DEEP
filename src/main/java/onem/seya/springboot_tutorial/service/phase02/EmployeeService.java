package onem.seya.springboot_tutorial.service.phase02;

import onem.seya.springboot_tutorial.models.phase02.Employee;

import java.util.List;

public interface EmployeeService {
    long getCount();
    public List<Employee> findAllEmployee();
    public boolean insertEmployee(Employee employee);
    public Employee findEmployeeById(Long id);
    public boolean deleteEmployee(long id);
}
