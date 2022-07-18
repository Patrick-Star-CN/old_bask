package team.oldbask.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Data
@Accessors(chain = true)
public class Code2Session {

    private String openId;

    private String sessionKey;

    private String unionId;

    private Integer errCode;

    private String errMsg;
}
