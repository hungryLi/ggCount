package platform.jizhang.biu.service.persistence.mybatis;

import platform.jizhang.biu.service.model.ConsumeTypeVO;

public interface ConsumeTypeVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumeTypeVO record);

    int insertSelective(ConsumeTypeVO record);

    ConsumeTypeVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumeTypeVO record);

    int updateByPrimaryKey(ConsumeTypeVO record);
}