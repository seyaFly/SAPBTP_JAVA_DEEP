package onem.seya.springboot_tutorial.controller.phase01;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = WelcomeController.path, produces = { APPLICATION_JSON_VALUE })
@RequestScope
@Api(value = WelcomeController.path)
public class WelcomeController {
    public static final String path = "/api/v1";

    @ApiOperation(value = "welcome message", nickname = "printWelcomeMessage", notes = "", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "success print welcome message"),
            @ApiResponse(code = 400, message = "invalid request body")})
    @GetMapping(value = "/welcome", produces = {APPLICATION_JSON_VALUE})
    public String printWelcomeMessage(){
        String welcomeMessage = "welcome to start the spring boot project in SCP Cloud Foundry";
        return welcomeMessage;
    }
}
