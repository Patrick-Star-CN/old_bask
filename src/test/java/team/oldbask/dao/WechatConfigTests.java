package team.oldbask.dao;

import cn.binarywang.wx.miniapp.api.WxMaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.oldbask.config.WechatProperties;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WechatConfigTests {

    @Test
    public void test() {
        System.out.println(WechatProperties.getAppid());
        System.out.println(WechatProperties.getSecret());
    }
}
