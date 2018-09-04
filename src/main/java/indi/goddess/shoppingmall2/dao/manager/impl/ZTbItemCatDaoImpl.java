package indi.goddess.shoppingmall2.dao.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import indi.goddess.shoppingmall2.beans.TbItemCat;
import indi.goddess.shoppingmall2.dao.manager.ZTbItemCatDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZTbItemCatDaoImpl implements ZTbItemCatDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbItemCat> findAll() {
        return sqlSession.selectList("com.pinyougou.mapper.ZTbItemCatMapper.findAll");
    }

//    没写完
    @Override
    public PageResult findPage(int pageNum, int pageSize) {//分页
        PageHelper.startPage(pageNum, pageSize);
        List<TbItemCat> list = sqlSession.selectList("com.pinyougou.mapper.ZTbItemCatMapper.findPage");
        PageInfo<TbItemCat> pageInfo = new PageInfo<TbItemCat>(list);
        return null;
    }

    @Override
    public PageResult findPage(TbItemCat itemCat, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void add(TbItemCat itemCat) {
        sqlSession.insert("com.pinyougou.mapper.ZTbItemCatMapper.insert",itemCat);
    }

    @Override
    public void update(TbItemCat itemCat) {
        sqlSession.update("com.pinyougou.mapper.ZTbItemCatMapper.updateByPrimaryKeySelective",itemCat);
    }

    @Override
    public TbItemCat findOne(Long id) {
        return sqlSession.selectOne("com.pinyougou.mapper.ZTbItemCatMapper.findOne",id);
    }

    @Override
    public void delete(Long[] ids) {
        sqlSession.delete("com.pinyougou.mapper.ZTbItemCatMapper.deleteMany",ids);
    }


    @Override
    public List<TbItemCat> findByParentId(Long parentId) {
        return sqlSession.selectList("com.pinyougou.mapper.ZTbItemCatMapper.findByParentId",parentId);
    }
}
