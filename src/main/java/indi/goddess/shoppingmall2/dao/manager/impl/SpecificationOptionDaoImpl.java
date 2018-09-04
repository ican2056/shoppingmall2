package indi.goddess.shoppingmall2.dao.manager.impl;

import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.beans.TbSpecificationOption;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.dao.manager.TbSpecificationOptionDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecificationOptionDaoImpl implements TbSpecificationOptionDao {
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public List<TbSpecificationOption> selectById(Long id) {
        return this.sqlSession.selectList("com.goddess.mapper.TbSpecificationOptionMapper.selectByPrimaryKey",id);
    }

    @Override
    public void delete(TbSpecificationOption option) {
        this.sqlSession.delete("com.goddess.mapper.TbSpecificationOptionMapper.deleteByPrimaryKey",option);
    }

    @Override
    public void insert(TbSpecificationOption specificationOption) {
        this.sqlSession.insert("com.goddess.mapper.TbSpecificationOptionMapper.insert",specificationOption);
    }
}
