package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.ConsumeTypeVO;

public interface ConsumeTypeVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumeTypeVO record);

    int insertSelective(ConsumeTypeVO record);

    ConsumeTypeVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumeTypeVO record);

    int updateByPrimaryKey(ConsumeTypeVO record);

	List<Map<String, Object>> queryTypes(Map<String, Object> reqMap);
}