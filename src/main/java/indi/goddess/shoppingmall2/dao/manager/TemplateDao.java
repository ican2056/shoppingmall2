package indi.goddess.shoppingmall2.dao.manager;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate;

import java.util.List;

public interface TemplateDao {
    public List<TbTypeTemplate> findAllTemplate();

    public void addTemplate(TbTypeTemplate template);

    /**
     * 修改品牌
     */
    public void updateByPrimaryKey(TbTypeTemplate template);

    //根据id获取实体
    public TbTypeTemplate selectByPrimaryKey(Long id);

    public void deleteByPrimaryKey(Long id);

    public List<TbTypeTemplate> findByCondition(TbTypeTemplate template);
}
