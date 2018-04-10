package platform.jizhang.biu.service.persistence.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import platform.common.mybatis.pageinterceptor.domain.PageBounds;
import platform.jizhang.biu.service.persistence.dao.CostInfoDao;

public class CostInfoDaoImpl implements CostInfoDao {

	public SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List queryCostInfoListByPage(Map<String, Object> map, PageBounds pageBounds) {
		List list =  sqlSession.selectList("platform.console.account.service.persistence.mybatis.CostInfoVOMapper.selectCostListByCondition", map, pageBounds);
		return list;
	}

}
