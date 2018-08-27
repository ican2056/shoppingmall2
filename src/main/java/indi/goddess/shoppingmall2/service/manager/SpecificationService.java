package indi.goddess.shoppingmall2.service.manager;

import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.entity.PageResult;

public interface SpecificationService {
    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);
    //增加规格
    public void add(Specification specification);
}
