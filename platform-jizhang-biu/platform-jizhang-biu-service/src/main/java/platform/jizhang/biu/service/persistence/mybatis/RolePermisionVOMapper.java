package platform.jizhang.biu.service.persistence.mybatis;

import platform.jizhang.biu.service.model.RolePermisionVO;

public interface RolePermisionVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermisionVO record);

    int insertSelective(RolePermisionVO record);

    RolePermisionVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermisionVO record);

    int updateByPrimaryKey(RolePermisionVO record);
}