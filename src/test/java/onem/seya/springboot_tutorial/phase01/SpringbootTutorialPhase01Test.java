package onem.seya.springboot_tutorial.phase01;

import onem.seya.springboot_tutorial.controller.phase01.WelcomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)
public class SpringbootTutorialPhase01Test {

    private String welcomeApiUrl = "/api/v1/welcome";

    @Autowired
    private MockMvc mvc;  //mockMvc

    /**
     * Test the welcome API
     */
    @Test
    public void testWelcomeController() throws Exception {
        mvc.perform(get(welcomeApiUrl))
                            .andExpect(status()
                                    .isOk())
                            .andExpect(content()
                                    .string(WelcomeController.welcomeMessage));
    }
}
