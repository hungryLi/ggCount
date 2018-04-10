package platform.jizhang.biu.service.persistence.mybatis;

import platform.jizhang.biu.service.model.RoleVO;

public interface RoleVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleVO record);

    int insertSelective(RoleVO record);

    RoleVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);
}