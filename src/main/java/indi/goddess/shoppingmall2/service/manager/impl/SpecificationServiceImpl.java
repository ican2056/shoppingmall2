package indi.goddess.shoppingmall2.service.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.beans.TbSpecificationOption;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.dao.manager.SpecificationDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.manager.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationDao specificationDao;
    //增加规格
    @Override
    public void add(Specification specification) {
        specificationDao.insert(specification.getSpecification());//插入规格
        //循环插入规格选项
        for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()){	specificationOption.setSpecId(specification.getSpecification().getId());//设置规格ID		specificationOptionMapper.insert(specificationOption);
        }
    }
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page= (Page<TbSpecification>) specificationDao.findAllSpecification();
        return new PageResult(page.getTotal(),page.getResult());

    }
}
