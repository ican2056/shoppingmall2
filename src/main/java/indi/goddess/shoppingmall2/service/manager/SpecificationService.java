package indi.goddess.shoppingmall2.service.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.entity.PageResult;

import java.util.List;
import java.util.Map;

public interface SpecificationService {
    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);
    //增加规格
    public void add(Specification specification);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public Specification findOne(Long id);

    /**
     * 修改
     */
    public void update(Specification specification);

    //获取下拉列表
    List<Map> selectOptionList();

    //条件查询
    public PageResult findPageByCondition(TbSpecification specification, int pageNum, int pageSize);
}
