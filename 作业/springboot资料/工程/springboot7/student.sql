/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2018-12-03 09:04:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bj`
-- ----------------------------
DROP TABLE IF EXISTS `bj`;
CREATE TABLE `bj` (
  `id` int(11) NOT NULL auto_increment,
  `bjname` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bj
-- ----------------------------
INSERT INTO `bj` VALUES ('5', '发给1p8');
INSERT INTO `bj` VALUES ('7', '3班');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL auto_increment,
  `sno` varchar(30) default NULL,
  `sname` varchar(30) default NULL,
  `sex` varchar(30) default NULL,
  `bjid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `bjid` (`bjid`),
  CONSTRAINT `bjid` FOREIGN KEY (`bjid`) REFERENCES `bj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '0011', '张三118', '女', '5');
INSERT INTO `student` VALUES ('5', '67', '分', '男', '7');
INSERT INTO `student` VALUES ('6', '11', '11', '女', '5');
INSERT INTO `student` VALUES ('7', '44', '44', '女', '7');
INSERT INTO `student` VALUES ('8', '1234', ' 的', '男', '5');
INSERT INTO `student` VALUES ('9', 'aa', 'aa', '女', '7');
INSERT INTO `student` VALUES ('10', 'qq', 'qq', '女', '7');
INSERT INTO `student` VALUES ('11', 'wwww', 'www', '女', '7');
