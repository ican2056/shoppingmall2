package indi.goddess.shoppingmall2.dao.manager.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.dao.manager.SpecificationDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        this.sqlSession.insert("com.goddess.mapper.TbSpecificationMapper.addrecord",record);
    }
}
