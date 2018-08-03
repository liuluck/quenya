package net.quenya.mapper;

import lombok.extern.slf4j.Slf4j;
import net.quenya.BaseTest;
import net.quenya.model.entity.User;
import net.quenya.model.mapper.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 *
 */
@Slf4j
//@Ignore
public class UserMapperTest extends BaseTest {


    @Autowired
    private UserMapper userMapper;

    private User user;

//    @Ignore
    @Before
    public void before() {
        log.info("before");
    }

//    @Ignore
    @Test
    public void testInsert() {
        User admin = userMapper.findByLoginName("admin");
        log.debug("admin id:{}",admin.id);
    }
    @Ignore
    @After
    public void after() {
        log.info("after");

    }

}
