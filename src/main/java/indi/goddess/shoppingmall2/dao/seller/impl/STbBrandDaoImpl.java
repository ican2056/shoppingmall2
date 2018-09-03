package indi.goddess.shoppingmall2.dao.seller.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.dao.seller.TbBrandDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class STbBrandDaoImpl implements TbBrandDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<TbBrand> findAll() {
        return sqlSession.selectList("com.pinyougou.mapper.TbBrandMapper.selectOptionList");
    }

    @Override
    public PageResult findByPage(TbBrand brand, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void save(TbBrand brand) {
        sqlSession.insert("com.pinyougou.mapper.TbBrandMapper.insertSelective",brand);
    }

    @Override
    public TbBrand findById(Long id) {
        return sqlSession.selectOne("com.pinyougou.mapper.TbBrandMapper.selectByPrimaryKey",id);
    }

    @Override
    public void update(TbBrand brand) {
        sqlSession.update("com.pinyougou.mapper.TbBrandMapper.updateByPrimaryKeySelective",brand);
    }

    @Override
    public void delete(Long[] ids) {
        sqlSession.delete("com.pinyougou.mapper.TbBrandMapper.deleteByPrimaryKey",ids);
    }

    @Override
    public List<Map> selectOptionList() {
        return sqlSession.selectList("com.pinyougou.mapper.TbBrandMapper.selectOptionList");
    }
}
