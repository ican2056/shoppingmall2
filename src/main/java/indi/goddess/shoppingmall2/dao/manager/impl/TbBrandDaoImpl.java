package indi.goddess.shoppingmall2.dao.manager.impl;

import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.dao.manager.TbBrandDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TbBrandDaoImpl  implements TbBrandDao{
    @Autowired
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<TbBrand> findAllBrand() {

        return this.sqlSession.selectList("com.goddess.mapper.TbBrandMapper.selectAllBrand");
    }

    @Override
    public void addBrand(TbBrand brand) {
         this.sqlSession.insert("com.goddess.mapper.TbBrandMapper.addBrand",brand);
    }

    @Override
    public void updateByPrimaryKey(TbBrand brand) {
        this.sqlSession.update("com.goddess.mapper.TbBrandMapper.updateByPrimaryKey",brand);
    }

    @Override
    public TbBrand selectByPrimaryKey(Long id) {
        return this.sqlSession.selectOne("com.goddess.mapper.TbBrandMapper.selectByPrimaryKey",id);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        this.sqlSession.delete("com.goddess.mapper.TbBrandMapper.deleteByPrimaryKey",id);
    }

    @Override
    public List<TbBrand> findByCondition(TbBrand tbBrand) {
        return this.sqlSession.selectList("com.goddess.mapper.TbBrandMapper.findByCondition",tbBrand);
    }

    @Override
    public List<Map> selectOptionList() {
        return this.sqlSession.selectList("com.goddess.mapper.TbBrandMapper.selectOptionList");
    }


}
