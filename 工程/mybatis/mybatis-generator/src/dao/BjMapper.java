package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vo.Bj;
import vo.BjExample;

public interface BjMapper {
    int countByExample(BjExample example);

    int deleteByExample(BjExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bj record);

    int insertSelective(Bj record);

    List<Bj> selectByExample(BjExample example);

    Bj selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bj record, @Param("example") BjExample example);

    int updateByExample(@Param("record") Bj record, @Param("example") BjExample example);

    int updateByPrimaryKeySelective(Bj record);

    int updateByPrimaryKey(Bj record);
}