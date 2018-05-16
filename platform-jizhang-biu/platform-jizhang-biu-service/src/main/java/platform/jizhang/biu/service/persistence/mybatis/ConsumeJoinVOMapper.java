package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;

import platform.jizhang.biu.service.model.ConsumeJoinVO;

public interface ConsumeJoinVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumeJoinVO record);

    int insertSelective(ConsumeJoinVO record);

    ConsumeJoinVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumeJoinVO record);

    int updateByPrimaryKey(ConsumeJoinVO record);

	int insertConsumeRecord(List<ConsumeJoinVO> joinList);
}