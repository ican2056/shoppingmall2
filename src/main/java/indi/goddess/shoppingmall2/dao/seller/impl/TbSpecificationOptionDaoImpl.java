package indi.goddess.shoppingmall2.dao.seller.impl;

import indi.goddess.shoppingmall2.beans.TbSpecificationOption;
import indi.goddess.shoppingmall2.dao.seller.TbSpecificationOptionDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbSpecificationOptionDaoImpl implements TbSpecificationOptionDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbSpecificationOption> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void add(TbSpecificationOption specificationOption) {

    }

    @Override
    public void update(TbSpecificationOption specificationOption) {

    }

    @Override
    public TbSpecificationOption findOne(Long id) {
        return sqlSession.selectOne("com.pinyougou.mapper.TbSpecificationOptionMapper.selectByPrimaryKey",id);
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbSpecificationOption specificationOption, int pageNum, int pageSize) {
        return null;
    }
}
