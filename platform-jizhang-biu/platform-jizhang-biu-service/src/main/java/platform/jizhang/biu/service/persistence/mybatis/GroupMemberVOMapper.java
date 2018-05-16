package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.GroupMemberVO;

public interface GroupMemberVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupMemberVO record);

    int insertSelective(GroupMemberVO record);

    GroupMemberVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupMemberVO record);

    int updateByPrimaryKey(GroupMemberVO record);

	List<Map<String, Object>> selectGroupMembers(Integer groupId);
}