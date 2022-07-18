package team.oldbask.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import team.oldbask.domain.User;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGetById() {
        userDao.selectById(1);
    }

    @Test
    public void testCreate() {
        User user = new User("22", "33", "44", "55", 66, "1");
        userDao.insert(user);
    }
}
