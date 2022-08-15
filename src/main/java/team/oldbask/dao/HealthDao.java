package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.oldbask.domain.model.Health;

/**
 * 用户健康情况数据层接口
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface HealthDao extends BaseMapper<Health> {

    /**
     * 通过uid来更新健康记录表
     * @param health 健康记录对象
     * @return 1: 更新成功; other: 更新失败
     */
    @Update("UPDATE tbl_health " +
            "SET breath = #{breath}, heart_rate = #{heartRate} " +
            "WHERE uid = #{uid}")
    int updateByUid(Health health);

    /**
     * 通过uid来获得数据
     * @param uid uid
     * @return 健康记录对象
     */
    @Select("SELECT * " +
            "FROM tbl_health " +
            "WHERE uid = #{uid}")
    Health selectByUid(int uid);
}
