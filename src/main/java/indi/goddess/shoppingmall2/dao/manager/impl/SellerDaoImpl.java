package indi.goddess.shoppingmall2.dao.manager.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.dao.manager.SellerDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerDaoImpl implements SellerDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<TbSeller> findAllSeller() {

        return this.sqlSession.selectList("com.goddess.mapper.TbSellerMapper.selectAllSeller");
    }

    @Override
    public TbSeller selectByPrimaryKey(String id) {
        return this.sqlSession.selectOne("com.goddess.mapper.TbSellerMapper.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKey(TbSeller seller) {
        return this.sqlSession.update("com.goddess.mapper.TbSellerMapper.updateByPrimaryKey",seller);
    }

    @Override
    public List<TbSeller> findByCondition(TbSeller seller) {
        return this.sqlSession.selectList("com.goddess.mapper.TbSellerMapper.findByCondition",seller);
    }
}
