package indi.goddess.shoppingmall2.dao.manager.impl;

import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.dao.manager.SpecificationDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SpecificationDaoImpl implements SpecificationDao{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<TbSpecification> findAllSpecification() {
        return this.sqlSession.selectList("com.goddess.mapper.TbSpecificationMapper.selectAllSpecification");
    }

    @Override
    public void insert(TbSpecification record) {
        this.sqlSession.insert("com.goddess.mapper.TbSpecificationMapper.insert",record);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        this.sqlSession.insert("com.goddess.mapper.TbSpecificationMapper.deleteByPrimaryKey",id);
    }

    @Override
    public TbSpecification selectByPrimaryKey(Long id) {
        return this.sqlSession.selectOne("com.goddess.mapper.TbSpecificationMapper.selectByPrimaryKey",id);
    }

    @Override
    public List<TbSpecification> findByCondition(TbSpecification specification) {
        return this.sqlSession.selectList("com.goddess.mapper.TbSpecificationMapper.selectByCondition",specification);
    }

    @Override
    public void updateByPrimaryKey(TbSpecification specification) {
        this.sqlSession.update("com.goddess.mapper.TbSpecificationMapper.updateByPrimaryKey",specification);
    }

    @Override
    public List<Map> selectOptionList() {
        return this.sqlSession.selectList("com.goddess.mapper.TbSpecificationMapper.selectOptionList");
    }
}
