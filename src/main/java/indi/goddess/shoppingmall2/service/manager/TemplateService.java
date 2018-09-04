package indi.goddess.shoppingmall2.service.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate;
import indi.goddess.shoppingmall2.entity.PageResult;

public interface TemplateService {
   public PageResult findPage(int pageNum, int pageSize);

   /**
    * 增加品牌
    */
   public void add(TbTypeTemplate template);

   /**
    * 修改品牌
    */
   public void update(TbTypeTemplate template);

   //根据id获取实体
   public TbTypeTemplate findOne(Long id);

   /**
    * 批量删除
    * @param ids
    */
   public void delete(Long[] ids);

   //条件查询
   public PageResult findPageByCondition(TbTypeTemplate template, int pageNum, int pageSize);
}
