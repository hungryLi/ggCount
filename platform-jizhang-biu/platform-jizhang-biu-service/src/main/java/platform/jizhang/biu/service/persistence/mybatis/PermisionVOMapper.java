package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.PermisionVO;

public interface PermisionVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermisionVO record);

    int insertSelective(PermisionVO record);

    PermisionVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermisionVO record);

    int updateByPrimaryKey(PermisionVO record);

	List<Map<String, Object>> selectPermisions(Integer roleId);
}