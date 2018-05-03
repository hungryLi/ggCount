package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.UserVO;

public interface UserVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVO record);

    int insertSelective(UserVO record);

    UserVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVO record);

    int updateByPrimaryKey(UserVO record);
    
    List<Map<String, Object>> selectUserInfo(Map<String, Object> reqMap);

	Integer selectUserByName(String string);
	
}