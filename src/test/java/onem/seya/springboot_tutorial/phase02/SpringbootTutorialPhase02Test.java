package onem.seya.springboot_tutorial.phase02;

import onem.seya.springboot_tutorial.models.phase02.Employee;
import onem.seya.springboot_tutorial.repository.phase02.EmployeeRepository;
import onem.seya.springboot_tutorial.service.phase02.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringbootTutorialPhase02Test {

    private Employee employee;

    @Autowired
    private MockMvc mvc;  //mockMvc

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;


    /**
     * 1. 初始化Employee对象
     * 2. 初始化数据库
     */
    @Before
    public void prepare(){
        String firstName = "Jack",
               lastName = "Smith",
               contact = "Tom.Smith",
               email = "jack.smith@test.com";

        employee = new Employee(firstName,lastName,email,contact);
        employee.setId(1);
        this.employeeRepository.deleteAll();
    }

    /**
     * clear employee object
     */
    @After
    public void tearDown(){
        employee = null;
    }

    /**
     * 001: CRUD for test employee
     */
    @Test
    public void test001EmployeeForCRUD() {
        long employeeCount = 0;
        boolean insertEmployeeStatus = false;


        employeeCount = this.employeeService.getCount();
        assertEquals(employeeCount, 0);

        //insert one employee
        insertEmployeeStatus = this.employeeService.insertEmployee(employee);
        assertTrue(insertEmployeeStatus);

        //query employee
        Employee selectedEmployee = this.employeeService.findEmployeeById((long) 1);
        assertEquals(selectedEmployee.getFirstName(),employee.getFirstName());
        assertEquals(selectedEmployee.getLastName(),employee.getLastName());
        assertEquals(selectedEmployee.getContact(),employee.getContact());
        assertEquals(selectedEmployee.getEmail(), employee.getEmail());

        //query all employee;
        List<Employee> employeeList = this.employeeService.findAllEmployee();
        assertEquals(employeeList.size(), 1);

        //remove employee by Id
        this.employeeService.deleteEmployee(1);
        employeeCount = this.employeeService.getCount();
        assertEquals(employeeCount, 0);
    }
}
