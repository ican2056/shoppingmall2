package indi.goddess.shoppingmall2.service.foreground;

import indi.goddess.shoppingmall2.beans.TbUser;
import indi.goddess.shoppingmall2.entity.PageResult;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbUser> findAll();
	/**
	 * 登陆
	 */
	public TbUser find(TbUser user);

	/**
	 * 用户名是否存在
	 * @param user
	 * @return
	 */
	public boolean validate(TbUser user);

	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public int add(TbUser user);
	
	
	/**
	 * 修改
	 */
	public int update(TbUser user);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbUser findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbUser user, int pageNum, int pageSize);
	
	
	/**
	 * 发送短信验证码
	 * @param phone
	 */
	public void createSmsCode(String phone);
	
	/**
	 * 校验验证码
	 * @param phone
	 * @param code
	 * @return
	 */
	public boolean checkSmsCode(String phone, String code);
	
}
