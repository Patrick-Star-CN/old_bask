package team.oldbask.domain.model;

import lombok.Data;

/**
 * 用户健康情况实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class Health {
    private int uid;
    private int breath;
    private int heartRate;

    public Health(int uid, int breath, int heartRate) {
        this.uid = uid;
        this.breath = breath;
        this.heartRate = heartRate;
    }
}
