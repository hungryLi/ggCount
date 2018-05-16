package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.AccountGroupVO;

public interface AccountGroupVOMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(AccountGroupVO record);

    int insertSelective(AccountGroupVO record);

    AccountGroupVO selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(AccountGroupVO record);

    int updateByPrimaryKey(AccountGroupVO record);

	List<Map<String, Object>> selectGroups(Integer userId);
}