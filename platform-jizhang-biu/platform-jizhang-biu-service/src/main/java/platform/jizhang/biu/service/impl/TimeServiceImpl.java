package platform.jizhang.biu.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mchange.v2.c3p0.impl.NewProxyDatabaseMetaData;

import net.sf.json.JSONObject;
import platform.common.utils.MiscUtil;
import platform.common.utils.StringUtil;
import platform.jizhang.biu.service.ConsumeService;
import platform.jizhang.biu.service.TimeService;
import platform.jizhang.biu.service.model.ConsumeJoinVO;
import platform.jizhang.biu.service.model.ConsumeRecordVO;
import platform.jizhang.biu.service.persistence.mybatis.AccountGroupVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.ConsumeJoinVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.ConsumeRecordVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.ConsumeTypeVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.GroupMemberVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.LikeVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.RoleVOMapper;

@Component
@Service(version = "1.0.0")
public class TimeServiceImpl implements TimeService {

	private static final Logger logger = Logger.getLogger(TimeServiceImpl.class);

	@Autowired(required = true)
	private ConsumeRecordVOMapper consumeRecordMapper;


	@Override
	public String queryTimeList(Map<String, Object> reqMap) throws Exception {
		MiscUtil.convertMap(reqMap);
		JSONObject json = new JSONObject();
		Integer page_size = Integer.valueOf(reqMap.get("page_size").toString()); 
		Integer page_num = Integer.valueOf(reqMap.get("page_num").toString()); 
		page_num = (page_num - 1) * page_size;
		reqMap.put("page_num", page_num);
		List<Map<String, Object>> lists = consumeRecordMapper.listTimes(reqMap);
		
		json.put("code", 1000);
		json.put("msg", "success");
		json.put("count", lists == null ? 0 :lists.size());
		json.put("res_data", lists);
		return json.toString();
	}



	
	
	
	
	
}
