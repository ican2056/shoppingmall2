package indi.goddess.shoppingmall2.dao.manager.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate;
import indi.goddess.shoppingmall2.dao.manager.TemplateDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateDaoImpl implements TemplateDao{
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public List<TbTypeTemplate> findAllTemplate() {
        return this.sqlSession.selectList("com.goddess.mapper.TbTemplateMapper.selectAllTemplate");
    }

    @Override
    public void addTemplate(TbTypeTemplate template) {
        this.sqlSession.insert("com.goddess.mapper.TbTemplateMapper.insertSelective",template);
    }

    @Override
    public void updateByPrimaryKey(TbTypeTemplate template) {
        this.sqlSession.update("com.goddess.mapper.TbTemplateMapper.updateByPrimaryKey",template);
    }

    @Override
    public TbTypeTemplate selectByPrimaryKey(Long id) {
        return  this.sqlSession.selectOne("com.goddess.mapper.TbTemplateMapper.selectByPrimaryKey",id);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        this.sqlSession.delete("com.goddess.mapper.TbTemplateMapper.deleteByPrimaryKey",id);
    }

    public List<TbTypeTemplate> findByCondition(TbTypeTemplate template) {
        return this.sqlSession.selectList("com.goddess.mapper.TbTemplateMapper.findByCondition",template);
    }
}
