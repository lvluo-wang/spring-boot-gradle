/*
Navicat MySQL Data Transfer

Source Server         : locahost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-02-27 13:41:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('1', 'mickjoust', '30');
INSERT INTO `info` VALUES ('2', 'mick', '30');
INSERT INTO `info` VALUES ('3', 'joust', '29');
