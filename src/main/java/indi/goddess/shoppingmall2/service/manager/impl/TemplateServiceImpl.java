package indi.goddess.shoppingmall2.service.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate;
import indi.goddess.shoppingmall2.dao.manager.TemplateDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.manager.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService{
    @Autowired
    private TemplateDao templateDao;
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbTypeTemplate> page= (Page<TbTypeTemplate>) templateDao.findAllTemplate();
        return new PageResult(page.getTotal(),page.getResult());

    }

    @Override
    public void add(TbTypeTemplate template) {
        templateDao.addTemplate(template);
    }

    @Override
    public void update(TbTypeTemplate template) {
        templateDao.updateByPrimaryKey(template);
    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return templateDao.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids) {
            templateDao.deleteByPrimaryKey(id);
        }

    }

    @Override
    public PageResult findPageByCondition(TbTypeTemplate template, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbTypeTemplate> page= (Page<TbTypeTemplate>) templateDao.findByCondition(template);
        return new PageResult(page.getTotal(), page.getResult());

    }
}
