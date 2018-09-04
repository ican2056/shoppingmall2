package indi.goddess.shoppingmall2.service.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.entity.PageResult;

import java.util.List;
import java.util.Map;

//品牌列表
public interface BrandService {
    //返回所有品牌列表
    public List<TbBrand> findAllBrand();

    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加品牌
     */
    public void add(TbBrand brand);

    /**
     * 修改品牌
     */
    public void update(TbBrand brand);

    //根据id获取实体
    public TbBrand findOne(Long id);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    //条件查询
   public PageResult findPageByCondition(TbBrand tbBrand, int pageNum, int pageSize);

   //获取下拉列表
   List<Map> selectOptionList();


}
