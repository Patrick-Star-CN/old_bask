package team.oldbask.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.oldbask.dao.DiseaseDao;
import team.oldbask.dao.UserDao;
import team.oldbask.domain.Disease;
import team.oldbask.domain.DiseasePostForm;
import team.oldbask.server.DiseaseService;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseDao diseaseDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean submitDisease(DiseasePostForm diseasePostForm, String uid) {
        if (userDao.selectById(uid) == null) {
            return false;
        }
        Disease disease = diseaseDao.selectByUid(Integer.parseInt(uid));
        if (disease == null) {
            diseaseDao.insert(new Disease(
                    Integer.parseInt(uid),
                    diseasePostForm.getGastritis(),
                    diseasePostForm.getAsthma(),
                    diseasePostForm.getHypertension(),
                    diseasePostForm.getCoronaryAtheroscleroticHeartDisease(),
                    diseasePostForm.getHyperlipidemia(),
                    diseasePostForm.getFattyLiverDisease(),
                    diseasePostForm.getDiabetes(),
                    diseasePostForm.getGout()
            ));
        } else {
            diseaseDao.updateByUid(new Disease(
                    Integer.parseInt(uid),
                    diseasePostForm.getGastritis(),
                    diseasePostForm.getAsthma(),
                    diseasePostForm.getHypertension(),
                    diseasePostForm.getCoronaryAtheroscleroticHeartDisease(),
                    diseasePostForm.getHyperlipidemia(),
                    diseasePostForm.getFattyLiverDisease(),
                    diseasePostForm.getDiabetes(),
                    diseasePostForm.getGout()
            ));
        }
        return true;
    }

    @Override
    public Disease getDisease(String uid) {
        return null;
    }
}
