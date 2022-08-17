package team.oldbask.domain.form;

import lombok.Data;

/**
 * 用户健康情况提交表单实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class HealthForm {
    private int breath;
    private int heartRate;
}
