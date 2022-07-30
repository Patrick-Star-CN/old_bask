package team.oldbask.server;

import org.springframework.stereotype.Service;
import team.oldbask.domain.model.PersonalTaste;
import team.oldbask.domain.form.PersonalTasteForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Service
public interface PersonalTasteService {

    /**
     * 保存用户个人喜好信息
     * @param personalTastePostForm 个人喜好对象
     * @param uid uid
     * @return true: 保存成功; false: 保存失败
     */
    boolean submitPersonalTaste(PersonalTasteForm personalTastePostForm, String uid);

    /**
     * 通过uid获取该用户个人喜好信息
     * @param uid uid
     * @return 个人喜好对象
     */
    PersonalTaste getPersonalTaste(String uid);
}
