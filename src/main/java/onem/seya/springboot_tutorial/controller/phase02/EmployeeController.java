package onem.seya.springboot_tutorial.controller.phase02;

import io.swagger.annotations.*;
import onem.seya.springboot_tutorial.constant.ApiConstant;
import onem.seya.springboot_tutorial.models.phase02.Employee;
import onem.seya.springboot_tutorial.service.phase02.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = ApiConstant.VERSION, produces = { APPLICATION_JSON_VALUE })
@RequestScope
@Api(value = ApiConstant.VERSION)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "save Employee", nickname = "save employee info", notes = "", response = Boolean.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success save Employee"),
            @ApiResponse(code = 400, message = "invalid request body")})
    @PostMapping(value = "/saveEmployee", produces = {APPLICATION_JSON_VALUE})
    public Boolean saveEmployee(
            @ApiParam(value = "Employee Info", required = true) @RequestBody Employee employee, HttpServletResponse response){
        return employeeService.insertEmployee(employee);
    }
}
