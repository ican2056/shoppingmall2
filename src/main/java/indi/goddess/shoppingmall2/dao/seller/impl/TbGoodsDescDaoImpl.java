package indi.goddess.shoppingmall2.dao.seller.impl;

import indi.goddess.shoppingmall2.beans.TbGoodsDesc;
import indi.goddess.shoppingmall2.dao.seller.TbGoodsDescDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbGoodsDescDaoImpl implements TbGoodsDescDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbGoodsDesc> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void add(TbGoodsDesc goodsDesc) {
        sqlSession.insert("com.pinyougou.mapper.TbGoodsDescMapper.insertSelective",goodsDesc);
    }

    @Override
    public void update(TbGoodsDesc goodsDesc) {
        sqlSession.update("com.pinyougou.mapper.TbGoodsDescMapper.updateByPrimaryKey",goodsDesc);
    }

    @Override
    public TbGoodsDesc findOne(Long id) {
        return sqlSession.selectOne("com.pinyougou.mapper.TbGoodsDescMapper.selectByPrimaryKey",id);
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbGoodsDesc goodsDesc, int pageNum, int pageSize) {
        return null;
    }
}
