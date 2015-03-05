/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.28 : Database - mylogistics
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mylogistics` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mylogistics`;

/*Table structure for table `accounts` */

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `accounts_code` varchar(15) NOT NULL COMMENT '账户编号',
  `accounts_name` varchar(15) DEFAULT NULL COMMENT '账户名称',
  `initial_money` decimal(20,9) DEFAULT NULL COMMENT '初期金额',
  `current_money` decimal(20,9) DEFAULT NULL COMMENT '当前金额',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`,`accounts_code`),
  UNIQUE KEY `UNIQUE` (`accounts_code`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `accounts` */

insert  into `accounts`(`id`,`accounts_code`,`accounts_name`,`initial_money`,`current_money`,`memo`) values (5,'account00001','account00001',NULL,NULL,'account00001'),(6,'account00002','account00001',NULL,NULL,'account00001'),(7,'account00004','account00001',NULL,NULL,'account00001'),(8,'account000012','',NULL,NULL,''),(9,'account000015','',NULL,NULL,''),(10,'account0000111','',NULL,NULL,''),(11,'account0000122','',NULL,NULL,''),(12,'account0000144','',NULL,NULL,''),(13,'account00001223','32',NULL,NULL,''),(16,'dasd','asdasd',NULL,NULL,''),(17,'','',NULL,NULL,', , , , ');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(12) NOT NULL COMMENT '类别编码',
  `category_name` varchar(12) DEFAULT NULL COMMENT '类别名称',
  `parent_code` varchar(12) DEFAULT NULL COMMENT '父类编码',
  PRIMARY KEY (`id`,`category_code`),
  UNIQUE KEY `UNIQUE` (`category_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`category_code`,`category_name`,`parent_code`) values (2,'010000','粮油调料','000000'),(3,'020000','厨房用具','000000'),(4,'030000','食品饮料','000000'),(5,'040000','卫生用具','000000');

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `company_category` int(1) NOT NULL COMMENT '单位分类（1、供货单位；2、购买单位）',
  `company_code` varchar(12) NOT NULL COMMENT '单位编号',
  `company_name` varchar(24) NOT NULL COMMENT '单位名称',
  `tel` varchar(15) DEFAULT NULL COMMENT '单位联系电话',
  `address` varchar(64) DEFAULT NULL COMMENT '单位联系地址',
  `zip_code` varchar(6) DEFAULT NULL COMMENT '邮编',
  `fax` varchar(15) DEFAULT NULL COMMENT '传真',
  `email` varchar(24) DEFAULT NULL COMMENT 'Email',
  `contact` varchar(12) DEFAULT NULL COMMENT '联系人',
  `initial_receivable` decimal(10,9) DEFAULT NULL COMMENT '初期应收款',
  `total_receivable` decimal(10,9) DEFAULT NULL COMMENT '累计应收款',
  `initial_account_payable` decimal(10,9) DEFAULT NULL COMMENT '初期应付款',
  `total_account_payable` decimal(10,9) DEFAULT NULL COMMENT '累计应付款',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`,`company_code`),
  UNIQUE KEY `UNIQUE` (`company_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `company` */

insert  into `company`(`id`,`company_category`,`company_code`,`company_name`,`tel`,`address`,`zip_code`,`fax`,`email`,`contact`,`initial_receivable`,`total_receivable`,`initial_account_payable`,`total_account_payable`,`memo`) values (3,2,'test1144','test1144','','','','','','',NULL,NULL,NULL,NULL,''),(4,2,'test11455','test11455','12345678911','','','','','',NULL,NULL,NULL,NULL,'');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(15) NOT NULL COMMENT '商品唯一编码',
  `goods_batch` varchar(12) DEFAULT NULL COMMENT '商品批次',
  `goods_name` varchar(24) NOT NULL COMMENT '商品名称',
  `category` varchar(12) NOT NULL COMMENT '商品类别编码',
  `category_name` varchar(24) DEFAULT NULL,
  `bar_code` varchar(24) DEFAULT NULL COMMENT '条码',
  `unit` varchar(5) DEFAULT NULL COMMENT '单位（袋、瓶、箱等）',
  `specifications` varchar(24) DEFAULT NULL COMMENT '商品规格',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`,`goods_code`),
  UNIQUE KEY `unique_code` (`goods_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`goods_code`,`goods_batch`,`goods_name`,`category`,`category_name`,`bar_code`,`unit`,`specifications`,`memo`) values (3,'G000003',NULL,'G000003','010000','粮油调料','G000003','瓶','G000003','G000003'),(4,'account0000122',NULL,'account0000122','020000','厨房用具','dddd','','',''),(5,'test00001',NULL,'矿泉水','030000','食品饮料','0215433254432','瓶','12瓶一箱','test');

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `superiors_order_num` varchar(24) DEFAULT NULL COMMENT '上级订单号（接口开发预留）',
  `invoice_num` varchar(15) NOT NULL COMMENT '系统内部唯一单据号',
  `invoice_date` date NOT NULL COMMENT '单据日期',
  `invoice_time` datetime NOT NULL COMMENT '开单时间',
  `invoice_type` int(2) NOT NULL COMMENT '单据类型（1、进货单；2、销售单；-1、进货退货单；-2、销售退货单；3、其他入库单；4、其他出库单）',
  `company` varchar(12) DEFAULT NULL COMMENT '单位名称',
  `paid_amount` decimal(20,9) DEFAULT NULL COMMENT '实收金额',
  `wipe_zero_amount` decimal(20,9) DEFAULT NULL COMMENT '抹零金额',
  `operator` varchar(12) DEFAULT NULL COMMENT '操作人',
  `warehouse_code` varchar(12) NOT NULL COMMENT '发货（收货）仓库',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  `payee` varchar(12) DEFAULT NULL COMMENT '收款单位',
  `paymentAmount` decimal(20,9) DEFAULT NULL COMMENT '收款金额',
  `original_num` varchar(24) DEFAULT NULL COMMENT '原始单据号（若为退货单，对应原单据）',
  PRIMARY KEY (`id`,`invoice_num`),
  UNIQUE KEY `UNIQUE_CODE` (`invoice_num`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `invoice` */

insert  into `invoice`(`id`,`superiors_order_num`,`invoice_num`,`invoice_date`,`invoice_time`,`invoice_type`,`company`,`paid_amount`,`wipe_zero_amount`,`operator`,`warehouse_code`,`memo`,`payee`,`paymentAmount`,`original_num`) values (3,NULL,'63453','2015-02-09','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(4,NULL,'ASN0000001','2015-02-09','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(5,NULL,'ASN0000003','2015-02-09','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(6,NULL,'ASN0000004','2015-02-09','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(7,NULL,'ASN0000005','2015-02-09','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(8,NULL,'ASN0000009','2015-02-10','1970-01-01 13:35:40',1,'腾讯',NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(9,NULL,'ASN1000000','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(10,NULL,'ASN1000001','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(11,NULL,'ASN1000002','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(12,NULL,'ASN1000003','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(13,NULL,'ASN1000004','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(14,NULL,'ASN1000005','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(15,NULL,'ASN1000006','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(16,NULL,'ASN1000007','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(17,NULL,'ASN1000008','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(18,NULL,'ASN1000009','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(19,NULL,'ASN10000010','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(20,NULL,'ASN10000011','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(21,NULL,'ASN10000012','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(22,NULL,'ASN10000013','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(23,NULL,'ASN10000014','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(24,NULL,'ASN10000015','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(25,NULL,'ASN10000016','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(26,NULL,'ASN10000017','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(27,NULL,'ASN10000018','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(28,NULL,'ASN10000019','2015-02-10','1970-01-01 13:35:40',1,NULL,NULL,NULL,NULL,'124521',NULL,NULL,NULL,NULL),(29,NULL,'hh','2015-02-11','2015-02-11 16:47:35',1,'hh',NULL,NULL,'h','12414',NULL,NULL,NULL,NULL),(30,NULL,'dd','2015-02-11','2015-02-11 16:47:42',1,'dd',NULL,NULL,'dd','12414',NULL,NULL,NULL,NULL),(31,NULL,'123423','2015-02-12','2015-02-12 09:42:38',1,'单位名称',NULL,NULL,'职员名称','12414',NULL,NULL,NULL,NULL),(38,NULL,'ASN20150212004','2015-02-12','2015-02-12 11:18:28',1,'腾讯',NULL,NULL,'操作人','12414',NULL,NULL,NULL,NULL),(39,NULL,'ddddd','2015-03-03','2015-03-03 13:52:57',1,'dsddd',NULL,NULL,'dd','12414',NULL,NULL,NULL,NULL),(40,NULL,'rr','2015-03-03','2015-03-03 13:54:19',1,'rr',NULL,NULL,'rr','12414',NULL,NULL,NULL,NULL),(42,NULL,'dvdsfd','2015-03-03','2015-03-03 14:00:31',1,'dd',NULL,NULL,'dd','12414',NULL,NULL,NULL,NULL);

/*Table structure for table `invoice_details` */

DROP TABLE IF EXISTS `invoice_details`;

CREATE TABLE `invoice_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_num` varchar(15) NOT NULL COMMENT '主表外键',
  `goods_code` varchar(15) NOT NULL COMMENT '商品编号',
  `goods_name` varchar(24) DEFAULT NULL COMMENT '商品名称',
  `goods_unit` varchar(5) DEFAULT NULL COMMENT '单位',
  `goods_num` int(9) NOT NULL COMMENT '数量',
  `goods_unit_price` decimal(20,9) NOT NULL COMMENT '单价',
  `discount` decimal(20,9) DEFAULT NULL COMMENT '折扣',
  `discount_unit_price` decimal(20,9) DEFAULT NULL COMMENT '折后单价',
  `discount_amount` decimal(20,9) DEFAULT NULL COMMENT '折后金额',
  `goods_sum_price` decimal(20,9) NOT NULL COMMENT '总金额',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_INVOICE_NUM` (`invoice_num`),
  CONSTRAINT `FK_INVOICE_NUM` FOREIGN KEY (`invoice_num`) REFERENCES `invoice` (`invoice_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `invoice_details` */

insert  into `invoice_details`(`id`,`invoice_num`,`goods_code`,`goods_name`,`goods_unit`,`goods_num`,`goods_unit_price`,`discount`,`discount_unit_price`,`discount_amount`,`goods_sum_price`,`memo`) values (1,'63453','123','水',NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(2,'ASN0000001','124','烟',NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(3,'ASN0000003','125','酒',NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(4,'ASN0000004','126','花',NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(5,'ASN0000005','127','桌子',NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(6,'ASN0000009','234','香蕉',NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(7,'ASN0000009','256','梨',NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(8,'ASN1000000','2340',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(9,'ASN1000000','2560',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(10,'ASN1000001','2341',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(11,'ASN1000001','2561',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(12,'ASN1000002','2342',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(13,'ASN1000002','2562',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(14,'ASN1000003','2343',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(15,'ASN1000003','2563',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(16,'ASN1000004','2344',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(17,'ASN1000004','2564',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(18,'ASN1000005','2345',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(19,'ASN1000005','2565',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(20,'ASN1000006','2346',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(21,'ASN1000006','2566',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(22,'ASN1000007','2347',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(23,'ASN1000007','2567',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(24,'ASN1000008','2348',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(25,'ASN1000008','2568',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(26,'ASN1000009','2349',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(27,'ASN1000009','2569',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(28,'ASN10000010','23410',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(29,'ASN10000010','25610',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(30,'ASN10000011','23411',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(32,'ASN10000012','23412',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(33,'ASN10000012','25612',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(34,'ASN10000013','23413',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(35,'ASN10000013','25613',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(36,'ASN10000014','23414',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(37,'ASN10000014','25614',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(38,'ASN10000015','23415',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(39,'ASN10000015','25615',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(40,'ASN10000016','23416',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(41,'ASN10000016','25616',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(42,'ASN10000017','23417',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(43,'ASN10000017','25617',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(44,'ASN10000018','23418',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(45,'ASN10000018','25618',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(46,'ASN10000019','23419',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(47,'ASN10000019','25619',NULL,NULL,123,'2.000000000',NULL,NULL,NULL,'246.000000000',NULL),(50,'ASN20150212004','water','水','瓶',1000,'2.000000000',NULL,NULL,NULL,'200.000000000',''),(51,'ASN20150212004','smoke','香烟','条',1000,'210.000000000',NULL,NULL,NULL,'2000.000000000',''),(53,'dvdsfd','2','2','2',2,'2.000000000',NULL,NULL,NULL,'2.000000000','2');

/*Table structure for table `purview` */

DROP TABLE IF EXISTS `purview`;

CREATE TABLE `purview` (
  `purview_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `purview_name` varchar(12) DEFAULT NULL COMMENT '权限名称',
  `role_id` int(9) NOT NULL COMMENT '角色Id',
  PRIMARY KEY (`purview_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `purview` */

/*Table structure for table `receipts` */

DROP TABLE IF EXISTS `receipts`;

CREATE TABLE `receipts` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `receipt_num` varchar(15) NOT NULL COMMENT '单据编号',
  `receipt_date` datetime NOT NULL COMMENT '单据日期',
  `receipt_time` datetime NOT NULL COMMENT '开单时间',
  `receipt_type` int(2) DEFAULT NULL COMMENT '单据类型（1、收款单；2、付款单）',
  `company` varchar(15) DEFAULT NULL COMMENT '单位名称',
  `operatoe` varchar(24) DEFAULT NULL COMMENT '操作人',
  `discount_amount` decimal(10,9) DEFAULT NULL COMMENT '优惠金额',
  `accounts_code` varchar(15) DEFAULT NULL COMMENT '账户编号',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`,`receipt_num`),
  UNIQUE KEY `UNIQUE` (`receipt_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `receipts` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `role_id` int(9) NOT NULL COMMENT '角色编号',
  `role_name` varchar(12) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`,`role_id`),
  UNIQUE KEY `UNIQUE` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `user_code` varchar(15) NOT NULL COMMENT '职员编码',
  `user_name` varchar(24) DEFAULT NULL COMMENT '职员名称',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `address` varchar(64) DEFAULT NULL COMMENT '地址',
  `tel` varchar(15) DEFAULT NULL COMMENT '电话',
  `role_id` int(5) DEFAULT NULL COMMENT '角色',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`user_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_code`,`user_name`,`password`,`address`,`tel`,`role_id`,`memo`) values (1,'test','test',NULL,NULL,NULL,0,NULL);

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `warehouse_code` varchar(15) NOT NULL,
  `warehouse_name` varchar(32) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `contacts` varchar(32) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`,`warehouse_code`),
  UNIQUE KEY `UNIEQUE` (`warehouse_code`)
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=utf8;

/*Data for the table `warehouse` */

insert  into `warehouse`(`id`,`warehouse_code`,`warehouse_name`,`address`,`contacts`,`tel`,`memo`) values (57,'FSD','FSD','FSDff','dfSDFds','dFS','sDFdd'),(59,'sdfwers','sdfs','sdfs','ss','sdfs','s'),(63,'ds','d','d','d','dfs','d'),(83,'ffg','gggg','','','',''),(145,'ffffffff','','f','','',''),(207,'vfadgbnb','','','','',''),(210,'rfv','','','','',''),(211,'yhb','','','','',''),(215,'fve','','','','',''),(219,'hy','','','','',''),(221,'ju','','','','',''),(224,'nhf','','','','',''),(226,'nah','gf','','','',''),(228,'sgrfdg','','','','',''),(280,'WARE0000001','WARE0000001','WARE0000001','WARE0000001','WARE0000001','WARE0000001'),(281,'dddvfghd','','','','',''),(282,'test111','test111','test12','test111','test111','test111');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
