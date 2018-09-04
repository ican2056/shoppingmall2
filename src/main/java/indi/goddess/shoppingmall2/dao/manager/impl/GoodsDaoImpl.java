package indi.goddess.shoppingmall2.dao.manager.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.dao.manager.GoodsDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao{
    @Autowired
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public List<TbGoods> findAllGood() {
       // System.out.println(this.sqlSession.selectList("com.goddess.mapper.TbGoodsMapper.selectAllGoods"));
        return this.sqlSession.selectList("com.goddess.mapper.TbGoodsMapper.selectAllGoods");
    }

    @Override
    public TbGoods selectByPrimaryKey(Long id) {
        return this.sqlSession.selectOne("com.goddess.mapper.TbGoodsMapper.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKey(TbGoods goods) {
        return this.sqlSession.update("com.goddess.mapper.TbGoodsMapper.updateByPrimaryKey",goods);
    }

    @Override
    public List<TbGoods> findByCondition(TbGoods good) {
        return this.sqlSession.selectList("com.goddess.mapper.TbGoodsMapper.findByCondition",good);
    }
}
