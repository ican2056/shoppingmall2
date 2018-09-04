package indi.goddess.shoppingmall2.service.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import indi.goddess.shoppingmall2.beans.*;
import indi.goddess.shoppingmall2.beans.group.Specification;
import indi.goddess.shoppingmall2.dao.manager.SellerDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.manager.TbSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbSellerServiceImpl implements TbSellerService {

    @Autowired
    private SellerDao sellerDao;

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSeller> page= (Page<TbSeller>) sellerDao.findAllSeller();
        return new PageResult(page.getTotal(),page.getResult());

    }

    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    @Override
    public TbSeller findOne(String id) {
        return sellerDao.selectByPrimaryKey(id);
    }
    @Override
    public void updateStatus(String sellerId, String status) {
        TbSeller seller = sellerDao.selectByPrimaryKey(sellerId);
        seller.setStatus(status);
        sellerDao.updateByPrimaryKey(seller);
    }

    @Override
    public PageResult findPageByCondition(TbSeller seller, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSeller> page= (Page<TbSeller>) sellerDao.findByCondition(seller);
        return new PageResult(page.getTotal(), page.getResult());

    }
}
