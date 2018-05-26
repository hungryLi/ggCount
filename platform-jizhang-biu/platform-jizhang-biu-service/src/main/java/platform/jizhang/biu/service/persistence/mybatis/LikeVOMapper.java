package platform.jizhang.biu.service.persistence.mybatis;

import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.LikeVO;

public interface LikeVOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LikeVO record);

    int insertSelective(LikeVO record);

    LikeVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LikeVO record);

    int updateByPrimaryKey(LikeVO record);

	List<Map<String, Object>> listLikes(Integer userId);

	int deleteByRecordId(Integer rid);
}