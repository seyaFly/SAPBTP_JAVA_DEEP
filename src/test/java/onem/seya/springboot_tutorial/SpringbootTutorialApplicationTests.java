package onem.seya.springboot_tutorial;

import onem.seya.springboot_tutorial.controller.phase01.WelcomeController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)
class SpringbootTutorialApplicationTests {

    @Autowired
    private MockMvc mvc;

    /**
     *打印欢迎消息
     */
    @Test
    void testWelcomeController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/welcome")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

}
