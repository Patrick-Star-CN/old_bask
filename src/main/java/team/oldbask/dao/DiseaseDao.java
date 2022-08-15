package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.oldbask.domain.model.Disease;

/**
 * 保存用户疾病功能数据层接口
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface DiseaseDao extends BaseMapper<Disease> {

    /**
     * 通过uid来更新疾病数据
     * @param disease 更新后的实体对象
     * @return 1: 更新成功; 2: 更新失败
     */
    @Update("UPDATE tbl_disease " +
            "SET gastritis = #{gastritis}, asthma = #{asthma}, hypertension = #{hypertension}, " +
            "    coronary_atherosclerotic_heart_disease = #{coronaryAtheroscleroticHeartDisease}, " +
            "    hyperlipidemia = #{hyperlipidemia}, fatty_liver_disease = #{fattyLiverDisease}, " +
            "    diabetes = #{diabetes}, gout = #{gout} " +
            "WHERE uid = #{uid} ")
    int updateByUid(Disease disease);

    /**
     * 通过uid来获得数据
     * @param uid uid
     * @return 疾病对象
     */
    @Select("SELECT * " +
            "FROM tbl_disease " +
            "WHERE uid = #{uid} ")
    Disease selectByUid(Integer uid);
}
