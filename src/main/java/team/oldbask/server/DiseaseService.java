package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.domain.Disease;
import team.oldbask.domain.DiseasePostForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface DiseaseService {

    /**
     * 保存用户疾病信息
     * @param diseasePostForm 用户疾病信息
     * @param uid 用户id
     * @return 1: 保存成功; 2: 保存失败
     */
    Boolean submitDisease(DiseasePostForm diseasePostForm, String uid);

    /**
     * 通过uid获取该用户疾病信息
     * @param uid uid
     * @return 用户疾病信息对象
     */
    Disease getDisease(String uid);
}
