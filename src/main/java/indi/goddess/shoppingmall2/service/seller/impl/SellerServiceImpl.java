package indi.goddess.shoppingmall2.service.seller.impl;

import indi.goddess.shoppingmall2.beans.TbSeller;
import indi.goddess.shoppingmall2.dao.seller.TbSellerDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private TbSellerDao tbSellerDao;
    @Override
    public List<TbSeller> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int add(TbSeller seller) {
       int result =  tbSellerDao.add(seller);
       return result;
    }

    @Override
    public int update(TbSeller seller) {
         int result = tbSellerDao.update(seller);
        return result;
    }

    @Override
    public TbSeller findOne(String id) {
        return tbSellerDao.findOne(id);
    }

    @Override
    public void delete(String[] ids) {

    }

    @Override
    public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void updateStatus(String sellerId, String status) {

    }

    @Override
    public TbSeller login(TbSeller seller) {
        return tbSellerDao.login(seller);
    }
}
