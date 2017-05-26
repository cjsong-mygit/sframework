package murong.example;

import murong.aop.Performance;
import murong.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by murong on 2017/4/28.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
//@ActiveProfiles("dev")
public class ExampleTest {

    @Autowired
    private Performance performance;

    @Test
    public void testExample() throws Exception {
        performance.performance();
        System.out.println("hh");
    }
}