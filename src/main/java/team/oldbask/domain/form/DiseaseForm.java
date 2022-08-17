package team.oldbask.domain.form;

import lombok.Data;

/**
 * 疾病提交表单实体类
 * @author Patrick_Star
 * @version 1.0
 */

@Data
public class DiseaseForm {
    private Boolean gastritis;
    private Boolean asthma;
    private Boolean hypertension;
    private Boolean coronaryAtheroscleroticHeartDisease;
    private Boolean hyperlipidemia;
    private Boolean fattyLiverDisease;
    private Boolean diabetes;
    private Boolean gout;
}
