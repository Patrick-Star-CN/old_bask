package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.HealthDao;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.Health;
import team.oldbask.domain.HealthPostForm;
import team.oldbask.domain.PersonalTaste;
import team.oldbask.server.HealthService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class HealthServiceImpl implements HealthService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HealthDao healthDao;

    @Override
    public boolean submitHealth(HealthPostForm healthPostForm, String uid) {
        if (userDao.selectById(uid) == null) {
            return false;
        }
        Health health = healthDao.selectByUid(Integer.parseInt(uid));
        if (health == null) {
            healthDao.insert(new Health(
                    Integer.parseInt(uid),
                    healthPostForm.getBreath(),
                    healthPostForm.getHeartRate()
            ));
        } else {
            healthDao.updateByUid(new Health(
                    Integer.parseInt(uid),
                    healthPostForm.getBreath(),
                    healthPostForm.getHeartRate()
            ));
        }
        return true;
    }

    @Override
    public Health getHealth(String uid) {
        return healthDao.selectByUid(Integer.parseInt(uid));
    }
}
