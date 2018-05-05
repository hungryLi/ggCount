package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.RoleVO;

public interface RoleVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleVO record);

    int insertSelective(RoleVO record);

    RoleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);

	List<Map<String, Object>>  selectTest(Map<String, Object> reqMap);

	Integer countRole();

	List<Map<String, Object>> queryRoles(Map<String, Object> reqMap);
}