package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.ConsumeRecordVO;

public interface ConsumeRecordVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumeRecordVO record);

    int insertSelective(ConsumeRecordVO record);

    ConsumeRecordVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumeRecordVO record);

    int updateByPrimaryKey(ConsumeRecordVO record);

	int updateRecordLike(ConsumeRecordVO record);

	List<Map<String, Object>> listTimes(Map<String, Object> reqMap);
}