package indi.goddess.shoppingmall2.service.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.entity.PageResult;

public interface TbGoodsService {

    //分页
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 批量修改状态
     * @param ids
     * @param status
     */
    public void updateStatus(Long[] ids, String status);

    public void delete(Long[] ids);
    //条件查询
    public PageResult findPageByCondition(TbGoods good, int pageNum, int pageSize);
}
