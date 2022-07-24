package team.oldbask.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team.oldbask.domain.PersonalTaste;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Mapper
public interface PersonalTasteDao extends BaseMapper<PersonalTaste> {

    /**
     * 通过uid来关系个人口味表
     * @param personalTaste 更新了数据后的实体类对象
     * @return 1: 更新成功; other: 更新失败
     */
    @Update("UPDATE tbl_personal_taste " +
            "SET sour = #{sour}, sweet = #{sweet}, bitterness = #{bitterness}, spicy = #{spicy}, " +
            "    salty = #{salty}, light = #{light}, five_spice = #{fiveSpice}, scallion = #{scallion}, " +
            "    garlic = #{garlic}, milk_fragrance = #{milkFragrance}, soy_sauce = #{soySauce}, curry = #{curry}, " +
            "    cumin = #{cumin}, fruity = #{fruity}, vanilla = #{vanilla}, sweet_fragrance = #{sweetFragrance}, " +
            "    dairy_allergy = #{dairyAllergy}, protein_allergy = #{proteinAllergy}, nut_allergy = #{nutAllergy}, seafood_allergy = #{seafoodAllergy}, " +
            "    soy_allergy = #{soyAllergy}, wheat_allergy = #{wheatAllergy}, peanut_allergy = #{peanutAllergy} " +
            "WHERE uid = #{uid}")
    int updateByUid(PersonalTaste personalTaste);

    /**
     * 通过uid来获得数据
     * @param uid uid
     * @return 个人口味对象
     */
    @Select("SELECT * " +
            "FROM tbl_personal_taste " +
            "WHERE uid = #{uid} ")
    PersonalTaste selectByUid(Integer uid);
}
