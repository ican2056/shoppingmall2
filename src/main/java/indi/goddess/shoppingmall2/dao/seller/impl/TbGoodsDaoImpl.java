package indi.goddess.shoppingmall2.dao.seller.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import indi.goddess.shoppingmall2.beans.TbGoods;
import indi.goddess.shoppingmall2.beans.TbItem;
import indi.goddess.shoppingmall2.beans.group.Goods;
import indi.goddess.shoppingmall2.dao.seller.TbGoodsDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbGoodsDaoImpl implements TbGoodsDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbGoods> findAll() {
        return sqlSession.selectList("com.pinyougou.mapper.TbGoodsMapper.findAll");
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbGoods> list = findAll();
        PageInfo<TbGoods> pageInfo = new PageInfo<TbGoods>(list);
        PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getList());
        return pageResult;
    }

    @Override
    public void add(Goods goods) {

    }

    @Override
    public void update(Goods goods) {

    }

    @Override
    public Goods findOne(Long id) {
        return sqlSession.selectOne("com.pinyougou.mapper.TbGoodsMapper.selectByPrimaryKey",id);
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void updateStatus(Long[] ids, String status) {

    }

    @Override
    public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] goodsIds, String status) {
        return null;
    }
}
