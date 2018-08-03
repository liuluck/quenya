package net.quenya;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseTest.SpringTestConfiguration.class)
@ActiveProfiles("local")
@AutoConfigureMockMvc
@Slf4j
@Ignore
public class BaseTest {
    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void test() {
        log.info("success!");
    }

    @SpringBootApplication(scanBasePackages = {"net.quenya"})
    static class SpringTestConfiguration {
    }
}
