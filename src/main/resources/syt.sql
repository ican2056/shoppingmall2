DROP TABLE IF EXISTS `tb_seller`;

CREATE TABLE `tb_seller` (
  `seller_id` varchar(100) NOT NULL COMMENT '用户ID',
  `name` varchar(80) DEFAULT NULL COMMENT '公司名',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `email` varchar(40) DEFAULT NULL COMMENT 'EMAIL',
  `mobile` varchar(11) DEFAULT NULL COMMENT '公司手机',
  `telephone` varchar(50) DEFAULT NULL COMMENT '公司电话',
  `status` varchar(1) DEFAULT '0' COMMENT '状态',
  `address_detail` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `linkman_name` varchar(50) DEFAULT NULL COMMENT '联系人姓名',
  `linkman_qq` varchar(13) DEFAULT NULL COMMENT '联系人QQ',
  `linkman_mobile` varchar(11) DEFAULT NULL COMMENT '联系人电话',
  `linkman_email` varchar(40) DEFAULT NULL COMMENT '联系人EMAIL',
  `license_number` varchar(20) DEFAULT NULL COMMENT '营业执照号',
  `tax_number` varchar(20) DEFAULT NULL COMMENT '税务登记证号',
  `org_number` varchar(20) DEFAULT NULL COMMENT '组织机构代码',
  `address` bigint(20) DEFAULT NULL COMMENT '公司地址',
  `logo_pic` varchar(100) DEFAULT NULL COMMENT '公司LOGO图',
  `brief` varchar(2000) DEFAULT NULL COMMENT '简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `legal_person` varchar(40) DEFAULT NULL COMMENT '法定代表人',
  `legal_person_card_id` varchar(25) DEFAULT NULL COMMENT '法定代表人身份证',
  `bank_user` varchar(50) DEFAULT NULL COMMENT '开户行账号名称',
  `bank_name` varchar(100) DEFAULT NULL COMMENT '开户行',
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_seller` */

insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('baidu','百度公司','百度商店','123456',NULL,NULL,'4004004400','1','西二旗小胡同','李彦宏','123456','1390000111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('huawei','华为公司','华为旗舰店','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,'010-0101010','1','西直门',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('itcast','传智播客集团','传智播客','123456',NULL,NULL,'010-88888888','1','北京市昌平区建材城西路金燕龙办公楼',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('itheima','黑马程序员','黑马程序员','123456',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('qiandu','千度公司','千度商店','$2a$10$uXL58WhPW/Nl.fScwezXN.BOm6xbM8TzkTxDYz55NqM5fkWjBvjpy',NULL,NULL,'8008008800','1','西三旗','李倩渡','1231234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `tb_seller`(`seller_id`,`name`,`nick_name`,`password`,`email`,`mobile`,`telephone`,`status`,`address_detail`,`linkman_name`,`linkman_qq`,`linkman_mobile`,`linkman_email`,`license_number`,`tax_number`,`org_number`,`address`,`logo_pic`,`brief`,`create_time`,`legal_person`,`legal_person_card_id`,`bank_user`,`bank_name`) values ('yijia','宜家公司','宜家','$2a$10$48L/s1R4aD1StL.sZF6u1uHGOllesyDkHK8KzWbAIGZplfwKsdwlC',NULL,NULL,'4004004400','1','西直门大街',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

SELECT * from tb_seller;


DROP TABLE IF EXISTS `tb_item_cat`;

CREATE TABLE `tb_item_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) DEFAULT NULL COMMENT '类目名称',
  `type_id` bigint(11) DEFAULT NULL COMMENT '类型id',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1205 DEFAULT CHARSET=utf8 COMMENT='商品类目';

select id,name from tb_item_cat;

select name from tb_item_cat where id in(
  select category1_id,category2_id,category3_id from tb_goods where id=149187842867958
);
select id, option_name, spec_id, orders from tb_specification_option


select * from tb_item_cat;
select database();
USE shoppingmall;


# 商品表
DROP TABLE IF EXISTS `tb_goods`;

CREATE TABLE `tb_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `seller_id` varchar(20) DEFAULT NULL COMMENT '商家ID',
  `goods_name` varchar(100) DEFAULT NULL COMMENT 'SPU名',
  `default_item_id` bigint(20) DEFAULT NULL COMMENT '默认SKU',
  `audit_status` varchar(2) DEFAULT NULL COMMENT '状态',
  `is_marketable` varchar(1) DEFAULT NULL COMMENT '是否上架',
  `brand_id` bigint(10) DEFAULT NULL COMMENT '品牌',
  `caption` varchar(100) DEFAULT NULL COMMENT '副标题',
  `category1_id` bigint(20) DEFAULT NULL COMMENT '一级类目',
  `category2_id` bigint(10) DEFAULT NULL COMMENT '二级类目',
  `category3_id` bigint(10) DEFAULT NULL COMMENT '三级类目',
  `small_pic` varchar(150) DEFAULT NULL COMMENT '小图',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商城价',
  `type_template_id` bigint(20) DEFAULT NULL COMMENT '分类模板ID',
  `is_enable_spec` varchar(1) DEFAULT NULL COMMENT '是否启用规格',
  `is_delete` varchar(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149187842867962 DEFAULT CHARSET=utf8;
insert  into `tb_goods`(`id`,`seller_id`,`goods_name`,`default_item_id`,`audit_status`,`is_marketable`,`brand_id`,`caption`,`category1_id`,`category2_id`,`category3_id`,`small_pic`,`price`,`type_template_id`,`is_enable_spec`,`is_delete`) values (149187842867912,'yijia','华为手机',NULL,'1',NULL,NULL,'打折促销中',NULL,NULL,NULL,NULL,'3020.00',NULL,NULL,NULL);
insert  into `tb_goods`(`id`,`seller_id`,`goods_name`,`default_item_id`,`audit_status`,`is_marketable`,`brand_id`,`caption`,`category1_id`,`category2_id`,`category3_id`,`small_pic`,`price`,`type_template_id`,`is_enable_spec`,`is_delete`) values (149187842867913,'yijia','华为手机',NULL,'1',NULL,NULL,'打折促销中',NULL,NULL,NULL,NULL,'3020.00',NULL,NULL,NULL);

DROP TABLE IF EXISTS `tb_goods_desc`;
SELECT *
FROM tb_goods;


CREATE TABLE `tb_goods_desc` (
  `goods_id` bigint(20) NOT NULL COMMENT 'SPU_ID',
  `introduction` varchar(3000) DEFAULT NULL COMMENT '描述',
  `specification_items` varchar(3000) DEFAULT NULL COMMENT '规格结果集，所有规格，包含isSelected',
  `custom_attribute_items` varchar(3000) DEFAULT NULL COMMENT '自定义属性（参数结果）',
  `item_images` varchar(3000) DEFAULT NULL,
  `package_list` varchar(3000) DEFAULT NULL COMMENT '包装列表',
  `sale_service` varchar(3000) DEFAULT NULL COMMENT '售后服务',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT *
FROM tb_goods_desc ;

CREATE TABLE `tb_type_template` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL COMMENT '模板名称',
  `spec_ids` varchar(1000) DEFAULT NULL COMMENT '关联规格',
  `brand_ids` varchar(1000) DEFAULT NULL COMMENT '关联品牌',
  `custom_attribute_items` varchar(2000) DEFAULT NULL COMMENT '自定义属性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

insert  into `tb_type_template`(`id`,`name`,`spec_ids`,`brand_ids`,`custom_attribute_items`) values (35,'手机','[{\"id\":27,\"text\":\"网络\"},{\"id\":32,\"text\":\"机身内存\"}]','[{\"id\":1,\"text\":\"联想\"},{\"id\":3,\"text\":\"三星\"},{\"id\":2,\"text\":\"华为\"},{\"id\":5,\"text\":\"OPPO\"},{\"id\":4,\"text\":\"小米\"},{\"id\":9,\"text\":\"苹果\"},{\"id\":8,\"text\":\"魅族\"},{\"id\":6,\"text\":\"360\"},{\"id\":10,\"text\":\"VIVO\"},{\"id\":11,\"text\":\"诺基亚\"},{\"id\":12,\"text\":\"锤子\"}]','[{\"text\":\"内存大小\"},{\"text\":\"颜色\"}]');
insert  into `tb_type_template`(`id`,`name`,`spec_ids`,`brand_ids`,`custom_attribute_items`) values (37,'电视','[{\"id\":33,\"text\":\"电视屏幕尺寸\"}]','[{\"id\":16,\"text\":\"TCL\"},{\"id\":13,\"text\":\"长虹\"},{\"id\":14,\"text\":\"海尔\"},{\"id\":19,\"text\":\"创维\"},{\"id\":21,\"text\":\"康佳\"},{\"id\":18,\"text\":\"夏普\"},{\"id\":17,\"text\":\"海信\"},{\"id\":20,\"text\":\"东芝\"},{\"id\":15,\"text\":\"飞利浦\"},{\"id\":22,\"text\":\"LG\"}]','[]');
SELECT * from tb_type_template;


CREATE TABLE `tb_specification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spec_name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
SELECT * from tb_specification;


CREATE TABLE `tb_specification_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规格项ID',
  `option_name` varchar(200) DEFAULT NULL COMMENT '规格项名称',
  `spec_id` bigint(30) DEFAULT NULL COMMENT '规格ID',
  `orders` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;
SELECT * from tb_specification_option;

CREATE TABLE `tb_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `first_char` varchar(1) DEFAULT NULL COMMENT '品牌首字母',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
SELECT *
FROM tb_brand;