package platform.jizhang.biu.service.persistence.mybatis;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import platform.jizhang.biu.service.model.AccountInfoVO;

public interface AccountInfoVOMapper {
    int deleteByPrimaryKey(Long accountId);

    int insert(AccountInfoVO record);

    int insertSelective(AccountInfoVO record);

    AccountInfoVO selectByPrimaryKey(Long accountId);
    
    AccountInfoVO selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(AccountInfoVO record);

    int updateByPrimaryKey(AccountInfoVO record);

	Map<String, Object> findAccountInfoById(Map<String, Object> reqMap);
	
	List<Map<String, Object>> findAllByPage(Map<String, Object> reqMap);
	
	BigDecimal selectByOneAccount(Map<String, Object> reqMap);
	
	long findAllByCount(Map<String, Object> reqMap);

	List<Map<String, Object>> queryAccountBalance(Map<String, Object> map);

	AccountInfoVO queryExistByUserId(Integer userId);
	/**
	 * 
	 * @param parMap
	 * @return
	 */
	AccountInfoVO selectByParMap(Map<String, Object> parMap);
	
	List<String> selectByNameMap (Map<String, Object> parMap);

	/**
	 * 代理商找自己的账户信息
	 * @param reqMap
	 * @return
	 */
    Map<String, Object> findAccountByType(Map<String, Object> reqMap);
    
    /**
     * 查找运营商代理商下的会员账户信息
     * account_name,operator_id agent_id
     */
    Map<String, Object> findAccountInfoByName(Map<String, Object> reqMap);

	int deleteByUserId(Long userId);
    
    /**
     * 维护运营商保证金余额
     * @param reqMap
     * @return
     */
	int setOperaSecuritDeposit(Map<String, Object> reqMap);

}