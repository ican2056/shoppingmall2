package indi.goddess.shoppingmall2.service.seller.impl;

import com.alibaba.fastjson.JSON;
import indi.goddess.shoppingmall2.beans.*;
import indi.goddess.shoppingmall2.beans.group.Goods;
import indi.goddess.shoppingmall2.dao.seller.*;
import indi.goddess.shoppingmall2.entity.PageResult;
import indi.goddess.shoppingmall2.service.seller.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private TbGoodsDao tbGoodsDao;
    @Autowired
    private TbGoodsDescDao tbGoodsDescDao;
    @Autowired
    private TbItemCatDao tbItemCatDao;
    @Autowired
    private TbItemDao tbItemDao;
    @Autowired
    private TbSellerDao tbSellerDao;
    @Autowired
    private TbBrandDao tbBrandDao;

    @Override
    public List<TbGoods> findAll() {
        return tbGoodsDao.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize,int auditStatus) {
        return tbGoodsDao.findPage(pageNum,pageSize,auditStatus);
    }

    @Override
    public void add(Goods goods) {

        goods.getGoods().setAuditStatus("0");
        tbGoodsDao.add(goods.getGoods());//插入商品表
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        tbGoodsDescDao.add(goods.getGoodsDesc());//插入商品扩展数据
//        if("1".equals(goods.getGoods().getIsEnableSpec())){
//            for(TbItem item :goods.getItemList()){
//                //标题
//                String title= goods.getGoods().getGoodsName();
//                Map<String,Object> specMap = JSON.parseObject(item.getSpec());
//                for(String key:specMap.keySet()){
//                    title+=" "+ specMap.get(key);
//                }
//                item.setTitle(title);
//                setItemValus(goods,item);
//                tbItemDao.add(item);
//            }
//        }else{
//            TbItem item=new TbItem();
//            item.setTitle(goods.getGoods().getGoodsName());//商品KPU+规格描述串作为SKU名称
//            item.setPrice( goods.getGoods().getPrice() );//价格
//            item.setStatus("1");//状态
//            item.setIsDefault("1");//是否默认
//            item.setNum(99999);//库存数量
//            item.setSpec("{}");
//            setItemValus(goods,item);
//            tbItemDao.add(item);
//        }

    }


    private void setItemValus(Goods goods,TbItem item) {
        /*item.setGoodsId(goods.getGoods().getId());//商品SPU编号
        item.setSellerId(goods.getGoods().getSellerId());//商家编号
        item.setCategoryid(goods.getGoods().getCategory3Id());//商品分类编号（3级）
        item.setCreateTime(new Date());//创建日期
        item.setUpdateTime(new Date());//修改日期

        //品牌名称
        TbBrand brand = tbBrandDao.findById(goods.getGoods().getBrandId());
        item.setBrand(brand.getName());
        //分类名称
        TbItemCat itemCat =  tbItemCatDao.findOne(goods.getGoods().getCategory3Id());
        item.setCategory(itemCat.getName());

        //商家名称
        TbSeller seller = tbSellerDao.findOne("baidu");//商家id
        item.setSeller(seller.getNickName());

        //图片地址（取spu的第一个图片）
        List<Map> imageList = JSON.parseArray(goods.getGoodsDesc().getItemImages(), Map.class) ;
        if(imageList.size()>0){
            item.setImage ( (String)imageList.get(0).get("url"));
        }*/
    }


    @Override
    public void update(Goods goods) {
        goods.getGoods().setAuditStatus("0");//设置未申请状态:如果是经过修改的商品，需要重新设置状态
        tbGoodsDao.update(goods.getGoods());//保存商品表
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        tbGoodsDescDao.update(goods.getGoodsDesc());//保存商品扩展表
        //删除原有的sku列表数据
//        TbItem example=new TbItem();
//        Long[] ids = new Long[]{};
//        ids[0]=example.getId();
//        tbItemDao.delete(ids);
//        //添加新的sku列表数据
//        saveItemList(goods);//插入商品SKU列表数据
    }

    @Override
    public Goods findOne(Long id) {
        Goods goods=new Goods();
        //查询SKU商品列表
        goods.setGoods(tbGoodsDao.findOne(id));
        goods.setGoodsDesc(tbGoodsDescDao.findOne(id));
        goods.setItemList(tbItemDao.findAll());
        return goods;
    }

    @Override
    public void delete(Long[] ids) {
        tbGoodsDao.delete(ids);
    }

    @Override
    public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void updateStatus(Long[] ids, String status) {
        for(Long id:ids){
            TbGoods goods = tbGoodsDao.findOne(id);
            goods.setAuditStatus(status);
            tbGoodsDao.update(goods);
        }

    }

    @Override
    public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] goodsIds, String status) {
        return null;
    }


    /**
     * 插入SKU列表数据
     * @param goods
     */
    private void saveItemList(Goods goods){
        if("1".equals(goods.getGoods().getIsEnableSpec())){
            for(TbItem item :goods.getItemList()){
                tbItemDao.add(item);
            }
        }else{
            TbItem item=new TbItem();
            tbItemDao.add(item);
        }
    }

}
