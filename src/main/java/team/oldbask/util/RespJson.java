package team.oldbask.util;

import lombok.Data;

/**
 * 返回给前端的JSON
 * @author Patrick_Star
 * @version 1.0
 */
@Data
public class RespJson {
    private int code;
    private String msg;
    private Object data;

    public RespJson() {
    }

    public RespJson(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RespJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}
