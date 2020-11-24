package onem.seya.springboot_tutorial.controller.phase01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(WelcomeController.path)
public class WelcomeController {
    public static final String path = "/api/v1";

    @GetMapping(value = "/welcome", produces = {APPLICATION_JSON_VALUE})
    public String printWelcomeMessage(){
        return "welcome to start the spring boot project in SCP Cloud Foundry";
    }
}
