package indi.goddess.shoppingmall2.service.foreground.impl;

import indi.goddess.shoppingmall2.beans.TbUser;
import indi.goddess.shoppingmall2.dao.foreground.TbUserDao;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.foreground.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource(name ="tbUserDaoImpl")
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> findAll() {
        return null;
    }

    @Override
    public TbUser find(TbUser user) {
        TbUser u= tbUserDao.findOne(user,"find");
        return u;
    }

    @Override
    public boolean validate(TbUser user) {
        user=tbUserDao.findOne(user,"isUserExists");
        if(user !=null){
            return true;
        }
        return false;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int add(TbUser user) {
        int result=tbUserDao.insert(user,"add");
        return result;
    }

    @Override
    public int update(TbUser user) {
        int result=tbUserDao.updateByPrimaryKeySelective(user,"updateByExample");
        return result;
    }

    @Override
    public TbUser findOne(Long id) {
        return null;
    }


    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbUser user, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void createSmsCode(String phone) {

    }

    @Override
    public boolean checkSmsCode(String phone, String code) {
        return false;
    }
}
