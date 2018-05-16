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
import platform.jizhang.biu.service.model.ConsumeJoinVO;
import platform.jizhang.biu.service.model.ConsumeRecordVO;
import platform.jizhang.biu.service.persistence.mybatis.AccountGroupVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.ConsumeJoinVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.ConsumeRecordVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.ConsumeTypeVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.GroupMemberVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.RoleVOMapper;

@Component
@Service(version = "1.0.0")
public class ConsumeServiceImpl implements ConsumeService {

	private static final Logger logger = Logger.getLogger(ConsumeServiceImpl.class);

	@Autowired(required=true)
	private AccountGroupVOMapper accountGroupMapper;
	@Autowired(required = true)
	private GroupMemberVOMapper groupMemberMapper;
	@Autowired(required = true)
	private ConsumeJoinVOMapper consumeJoinMapper;
	@Autowired(required = true)
	private ConsumeTypeVOMapper consumeTypeMapper;
	@Autowired(required = true)
	private ConsumeRecordVOMapper consumeRecordMapper;
	
	@Override
	public String queryGroups(Map<String, String> reqMap) throws Exception {
		Integer userId = Integer.valueOf(reqMap.get("user_id"));
		List<Map<String, Object>> groups = accountGroupMapper.selectGroups(userId);
		JSONObject json = new JSONObject();
		json.put("code", 1000);
		json.put("msg", "success");
		json.put("res_data", groups);
		return json.toString();
	}

	@Override
	public String queryGroupMembers(Map<String, String> reqMap) throws Exception {
		Integer groupId = Integer.valueOf(reqMap.get("group_id"));
		List<Map<String, Object>> members = groupMemberMapper.selectGroupMembers(groupId);
		JSONObject json = new JSONObject();
		json.put("code", 1000);
		json.put("msg", "success");
		json.put("res_data", members);
		return json.toString();
	}

	@Override
	@Transactional( propagation = Propagation.REQUIRED)
	public String addOneConsume(Map<String, String> reqMap) throws Exception {
		JSONObject json = new JSONObject();
		ConsumeRecordVO recode = new ConsumeRecordVO();
		Integer payUserId = Integer.valueOf(reqMap.get("pay_user_id"));
		BigDecimal totlePrice = new BigDecimal(reqMap.get("price"));
		recode.setConsumeTitle(reqMap.get("consume_title"));
		recode.setConsumeAddress(reqMap.get("consume_address"));
		recode.setHandlerType(Integer.valueOf(reqMap.get("handler_type")));
		recode.setPayUserId(payUserId);
		recode.setPrice(totlePrice);
		recode.setConsmueTime(new Date());
		recode.setStatus(0);
		recode.setPicAddress1(reqMap.get("pic_address1"));
		recode.setPicAddress2(reqMap.get("pic_address2"));
		recode.setConsumeDesc(reqMap.get("consume_desc"));
		if(!StringUtil.isEmpty(reqMap.get("consume_type"))) {
			recode.setConsumeType(Integer.valueOf(reqMap.get("consume_type")));
		}
		if(!StringUtil.isEmpty(reqMap.get("group_id"))) {
			recode.setGroupId(Integer.valueOf(reqMap.get("group_id")));
		}
		consumeRecordMapper.insertSelective(recode);
		Integer consumeRecordId = recode.getId(); //消费记录主键id
		
		List<Integer> needPayIds = JSON.parseObject(reqMap.get("user_ids"), new TypeReference<List<Integer>>() {});
		needPayIds.add(payUserId);
		BigDecimal costMount = totlePrice.divide(new BigDecimal(needPayIds.size()), BigDecimal.ROUND_HALF_UP).setScale(1);
		List<ConsumeJoinVO> joinList = new ArrayList<ConsumeJoinVO>(needPayIds.size());
		for(Integer userId : needPayIds) {
			ConsumeJoinVO joinVo = new ConsumeJoinVO();
			joinVo.setRecordId(consumeRecordId);
			joinVo.setPayUserId(userId);
			joinVo.setCostMount(costMount);
			joinVo.setStatus(0);
			joinList.add(joinVo);
		}
		consumeJoinMapper.insertConsumeRecord(joinList);
		json.put("code", 1000);
		json.put("msg", "success");
		return json.toString();
	}

	@Override
	public String queryConsumeType(Map<String, String> reqMap) throws Exception {
		
		return null;
	}


	
	
	
	
	
}
