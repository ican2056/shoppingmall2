package indi.goddess.shoppingmall2.dao.merchant.impl;

import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.dao.merchant.TbItemCatDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TbItemCatDaoImpl implements TbItemCatDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbItemCat> findAll() {
        return sqlSession.selectList("com.pinyougou.mapper.TbItemCatMapper.findAll");
    }

//    没写完
    @Override
    public PageResult findPage(int pageNum, int pageSize) {//分页
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        List<TbItemCat> list = sqlSession.selectList("com.pinyougou.mapper.TbItemCatMapper.findPage", map);

        PageResult pageResult= new PageResult(1,list);//总量

        return null;
    }

    @Override
    public PageResult findPage(TbItemCat itemCat, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void add(TbItemCat itemCat) {
        sqlSession.insert("com.pinyougou.mapper.TbItemCatMapper.insert",itemCat);
    }

    @Override
    public void update(TbItemCat itemCat) {
        sqlSession.update("com.pinyougou.mapper.TbItemCatMapper.updateByPrimaryKeySelective",itemCat);
    }

    @Override
    public TbItemCat findOne(Long id) {
        return sqlSession.selectOne("com.pinyougou.mapper.TbItemCatMapper.findOne",id);
    }

    @Override
    public void delete(Long[] ids) {
        sqlSession.delete("com.pinyougou.mapper.TbItemCatMapper.deleteMany",ids);
    }


    @Override
    public List<TbItemCat> findByParentId(Long parentId) {
        return sqlSession.selectList("com.pinyougou.mapper.TbItemCatMapper.findByParentId",parentId);
    }
}
