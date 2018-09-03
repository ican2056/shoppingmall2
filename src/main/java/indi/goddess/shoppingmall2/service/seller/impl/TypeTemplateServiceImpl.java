package indi.goddess.shoppingmall2.service.seller.impl;

import com.alibaba.fastjson.JSON;
import indi.goddess.shoppingmall2.beans.TbSpecificationOption;
import indi.goddess.shoppingmall2.beans.TbTypeTemplate;
import indi.goddess.shoppingmall2.dao.seller.TbSpecificationOptionDao;
import indi.goddess.shoppingmall2.dao.seller.TypeTemplateDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.seller.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {
    @Autowired
    private TypeTemplateDao typeTemplateDao;
    @Autowired
    private TbSpecificationOptionDao specificationOptionDao;
    @Override
    public List<TbTypeTemplate> findAll() {
        return typeTemplateDao.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return typeTemplateDao.findPage(pageNum,pageSize);
    }

    @Override
    public void add(TbTypeTemplate typeTemplate) {
        typeTemplateDao.add(typeTemplate);
    }

    @Override
    public void update(TbTypeTemplate typeTemplate) {
        typeTemplateDao.update(typeTemplate);
    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return typeTemplateDao.findOne(id);
    }

    @Override
    public void delete(Long[] ids) {
        typeTemplateDao.delete(ids);
    }

    @Override
    public PageResult findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
        return typeTemplateDao.findPage(typeTemplate,pageNum,pageSize);
    }

    @Override
    public List<Map> findSpecList(Long id) {
        //查询模板
        TbTypeTemplate typeTemplate = typeTemplateDao.findOne(id);
        List<Map> list = JSON.parseArray(typeTemplate.getSpecIds(), Map.class)  ;
        for(Map map:list){
            //查询规格选项列表
            TbSpecificationOption options = specificationOptionDao.findOne(id);
            map.put("options", options);
        }
        return list;
    }
}
