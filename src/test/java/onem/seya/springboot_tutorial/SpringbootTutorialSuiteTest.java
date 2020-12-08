package onem.seya.springboot_tutorial;

import onem.seya.springboot_tutorial.phase01.SpringbootTutorialPhase01Test;
import onem.seya.springboot_tutorial.phase02.SpringbootTutorialPhase02Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SpringbootTutorialPhase01Test.class,
        SpringbootTutorialPhase02Test.class
})
public class SpringbootTutorialSuiteTest {
}
