package team.oldbask.server;

import team.oldbask.domain.PersonalTaste;
import team.oldbask.domain.PersonalTastePostForm;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public interface PersonalTasteServer {

    /**
     * 保存用户个人喜好信息
     * @param personalTastePostForm 个人喜好对象
     * @param uid uid
     * @return true: 保存成功; false: 保存失败
     */
    boolean submitPersonalTaste(PersonalTastePostForm personalTastePostForm, String uid);

    /**
     * 通过uid获取该用户个人喜好信息
     * @param uid uid
     * @return 个人喜好对象
     */
    PersonalTaste getPersonalTaste(String uid);
}
