package indi.goddess.shoppingmall2.dao.merchant.impl;

import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.dao.merchant.TbSellerDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbSellerDaoImpl implements TbSellerDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbSeller> findAll() {
        return  sqlSession.selectList("com.pinyougou.mapper.TbSellerMapper.findAll");
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int add(TbSeller seller) {
        int result =  sqlSession.insert("com.pinyougou.mapper.TbSellerMapper.insertSelective",seller);
        return  result;
    }

    @Override
    public int update(TbSeller seller) {
       int result =  sqlSession.update("com.pinyougou.mapper.TbSellerMapper.updateByExampleSelective",seller);
       return result;
    }

    @Override
    public TbSeller findOne(String sellerId) {
        return sqlSession.selectOne("com.pinyougou.mapper.TbSellerMapper.selectByPrimaryKey",sellerId);
    }

    @Override
    public void delete(String[] ids) {

    }

    @Override
    public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void updateStatus(String sellerId, String status) {

    }

    @Override
    public TbSeller login(TbSeller seller) {
        return sqlSession.selectOne("com.pinyougou.mapper.TbSellerMapper.loginSeller",seller);
    }



}
