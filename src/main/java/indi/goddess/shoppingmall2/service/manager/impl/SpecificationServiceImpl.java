package indi.goddess.shoppingmall2.service.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.goddess.shoppingmall2.beans.TbBrand;
import indi.goddess.shoppingmall2.beans.TbSpecification;
import indi.goddess.shoppingmall2.beans.TbSpecificationOption;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.dao.manager.SpecificationDao;
import indi.goddess.shoppingmall2.dao.manager.TbSpecificationOptionDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.manager.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationDao specificationDao;

    @Autowired
    private TbSpecificationOptionDao specificationOptionDao;
    //增加规格
    @Override
    public void add(Specification specification) {
        specificationDao.insert(specification.getSpecification());//插入规格
        //循环插入规格选项
        for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()){
            specificationOption.setSpecId(specification.getSpecification().getId());//设置规格ID
            // specificationOptionMapper.insert(specificationOption);
        }
    }
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page= (Page<TbSpecification>) specificationDao.findAllSpecification();
        return new PageResult(page.getTotal(),page.getResult());

    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            specificationDao.deleteByPrimaryKey(id);
        }
    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public Specification findOne(Long id){
        //查询规格
        TbSpecification tbSpecification = specificationDao.selectByPrimaryKey(id);
        //查询规格选项列表
        TbSpecificationOption option=new TbSpecificationOption();

        List<TbSpecificationOption> optionList =  specificationOptionDao.selectById(id);
        //构建组合实体类返回结果
        Specification spec=new Specification();
        spec.setSpecification(tbSpecification);
        spec.setSpecificationOptionList(optionList);
        return spec;
    }

    /**
     * 修改
     */
    @Override
    public void update(Specification specification){
        //保存修改的规格
        specificationDao.updateByPrimaryKey(specification.getSpecification());//保存规格
        //删除原有的规格选项

        TbSpecificationOption option = new TbSpecificationOption();
        option.setSpecId(specification.getSpecification().getId());
        System.out.println("原有的规格选项"+specification.getSpecification().getId());
        specificationOptionDao.delete(option);//删除
        //循环插入规格选项
        for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()){
            specificationOption.setSpecId(specification.getSpecification().getId());
            specificationOptionDao.insert(specificationOption);
        }
    }

    @Override
    public List<Map> selectOptionList() {
        return specificationDao.selectOptionList();
    }

    @Override
    public PageResult findPageByCondition(TbSpecification  specification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification > page= (Page<TbSpecification >) specificationDao.findByCondition(specification);
        return new PageResult(page.getTotal(), page.getResult());

    }

}
