/*
Navicat MariaDB Data Transfer

Source Server         : vagrant-centos7
Source Server Version : 50556
Source Host           : 192.168.10.120:3306
Source Database       : seckill

Target Server Type    : MariaDB
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-04-18 16:05:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL,
  `goods_Name` varchar(32) DEFAULT NULL,
  `goods_Title` varchar(32) DEFAULT NULL,
  `goods_Img` varchar(64) DEFAULT NULL,
  `goods_Detail` mediumtext,
  `goods_Price` double DEFAULT NULL,
  `goods_Stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('0', 'huawei', 'huawei', '/img/meta10.png', 'huaweihuaweihuaweihuaweihuawei', '300', '10');
INSERT INTO `goods` VALUES ('2', 'xiaomi', 'xiaomi', '/img/mi6.png', 'xiaomixiaomixiaomixiaomixiaomi', '200', '10');
INSERT INTO `goods` VALUES ('3', 'oppo', 'oppo', '/img/iphone8.png', 'oppo手机oppo手机oppooppo', '230', '10');

-- ----------------------------
-- Table structure for miaosha_goods
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_goods`;
CREATE TABLE `miaosha_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_Id` bigint(20) DEFAULT NULL,
  `stock_Count` int(11) DEFAULT NULL,
  `start_Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_Date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `miaosha_price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of miaosha_goods
-- ----------------------------
INSERT INTO `miaosha_goods` VALUES ('1', '0', '10', '2018-04-18 08:56:41', '2018-04-19 14:43:20', '200.00');
INSERT INTO `miaosha_goods` VALUES ('2', '2', '10', '2018-04-19 08:52:51', '2018-04-19 14:43:54', '200.00');

-- ----------------------------
-- Table structure for miaosha_order
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_order`;
CREATE TABLE `miaosha_order` (
  `id` bigint(20) NOT NULL,
  `user_Id` bigint(20) DEFAULT NULL,
  `order_Id` bigint(20) DEFAULT NULL,
  `goods_Id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of miaosha_order
-- ----------------------------

-- ----------------------------
-- Table structure for miaosha_user
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_user`;
CREATE TABLE `miaosha_user` (
  `id` bigint(20) NOT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL,
  `head` varchar(64) DEFAULT NULL,
  `register_Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastLogin_Date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `login_Count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of miaosha_user
-- ----------------------------
INSERT INTO `miaosha_user` VALUES ('15071027574', 'luo', 'a5ef75bde574cf3b1154e4e484e51f87', '6c489a3441d24a6eafb04c9fc65c7103', null, '2018-04-18 08:16:43', '2018-04-18 14:16:38', null);

-- ----------------------------
-- Table structure for orderInfo
-- ----------------------------
DROP TABLE IF EXISTS `orderInfo`;
CREATE TABLE `orderInfo` (
  `id` bigint(20) NOT NULL,
  `user_Id` bigint(20) DEFAULT NULL,
  `goods_Id` bigint(20) DEFAULT NULL,
  `delivery_AddrId` bigint(20) DEFAULT NULL,
  `goods_Name` varchar(32) DEFAULT NULL,
  `goods_Count` int(11) DEFAULT NULL,
  `goods_Price` double DEFAULT NULL,
  `order_Channel` int(11) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `create_Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pay_Date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orderInfo
-- ----------------------------
