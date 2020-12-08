package onem.seya.springboot_tutorial.service.phase02.impl;

import onem.seya.springboot_tutorial.models.phase02.Employee;
import onem.seya.springboot_tutorial.repository.phase02.EmployeeRepository;
import onem.seya.springboot_tutorial.service.phase02.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public long getCount() {
        long count = employeeRepository.count();
        return count;
    }

    @Override
    public List<Employee> findAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee;
    }

    @Override
    public boolean deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee!=null) {
            employeeRepository.delete(employee);
            return true;
        }
        return false;
    }
}
