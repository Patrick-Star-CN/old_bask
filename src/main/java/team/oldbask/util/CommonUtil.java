package team.oldbask.util;

/**
 * @author Patrick_Star
 * @version 1.0
 * 通用工具类
 */
public class CommonUtil {
    public static boolean IntegerEqual(Integer left, Integer right) {
        if (right != null && left != null) {
            return right.intValue() == left.intValue();
        } else {
            return false;
        }
    }
}
