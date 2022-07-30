package team.oldbask.domain.model;

import lombok.Data;

/**
 * 用户所患疾病实体类
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class Disease {
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 胃炎
     */
    private Boolean gastritis;
    private Boolean asthma;
    private Boolean hypertension;
    private Boolean coronaryAtheroscleroticHeartDisease;
    private Boolean hyperlipidemia;
    private Boolean fattyLiverDisease;
    private Boolean diabetes;
    private Boolean gout;

    public Disease(Integer uid, Boolean gastritis, Boolean asthma, Boolean hypertension, Boolean coronaryAtheroscleroticHeartDisease, Boolean hyperlipidemia, Boolean fattyLiverDisease, Boolean diabetes, Boolean gout) {
        this.uid = uid;
        this.gastritis = gastritis;
        this.asthma = asthma;
        this.hypertension = hypertension;
        this.coronaryAtheroscleroticHeartDisease = coronaryAtheroscleroticHeartDisease;
        this.hyperlipidemia = hyperlipidemia;
        this.fattyLiverDisease = fattyLiverDisease;
        this.diabetes = diabetes;
        this.gout = gout;
    }
}
