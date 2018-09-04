package indi.goddess.shoppingmall2.service.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.entity.PageResult;

public interface TbSellerService {
    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    public TbSeller findOne(String id);

    /**
     * 更改状态
     * @param sellerId
     * @param status
     */
    public void updateStatus(String sellerId, String status);

    //条件查询
    public PageResult findPageByCondition(TbSeller seller, int pageNum, int pageSize);
}
