package platform.jizhang.biu.service.persistence.dao;

import java.util.List;
import java.util.Map;

import platform.common.mybatis.pageinterceptor.domain.PageBounds;

public interface CostInfoDao {
	
	public List queryCostInfoListByPage(Map<String, Object> map, PageBounds pageBounds);

}
