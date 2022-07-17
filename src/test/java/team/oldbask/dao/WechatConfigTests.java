package team.oldbask.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import team.oldbask.config.WechatConfig;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WechatConfigTests {

    @Test
    public void test() {
        System.out.println(WechatConfig.getAppId());
        System.out.println(WechatConfig.getAppSecret());
    }
}
