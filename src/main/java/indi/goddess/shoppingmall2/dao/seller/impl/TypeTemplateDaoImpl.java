package indi.goddess.shoppingmall2.dao.seller.impl;

import indi.goddess.shoppingmall2.beans.TbTypeTemplate;
import indi.goddess.shoppingmall2.dao.seller.TypeTemplateDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TypeTemplateDaoImpl implements TypeTemplateDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbTypeTemplate> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void add(TbTypeTemplate typeTemplate) {

    }

    @Override
    public void update(TbTypeTemplate typeTemplate) {

    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        TbTypeTemplate tbTypeTemplate =sqlSession.selectOne("com.pinyougou.mapper.TbTypeTemplateMapper.selectByPrimaryKey", id);
        return tbTypeTemplate;
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
        return null;
    }


}
