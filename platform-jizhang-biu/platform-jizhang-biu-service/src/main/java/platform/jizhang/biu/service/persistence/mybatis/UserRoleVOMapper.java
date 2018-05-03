package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.UserRoleVO;

public interface UserRoleVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleVO record);

    int insertSelective(UserRoleVO record);

    UserRoleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleVO record);

    int updateByPrimaryKey(UserRoleVO record);

	Map<String, Object> selectRolesByUserId(Integer userId);
	
}