/*
MySQL Data Transfer
Source Host: localhost
Source Database: student
Target Host: localhost
Target Database: student
Date: 2019/9/10 8:01:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for bj
-- ----------------------------
DROP TABLE IF EXISTS `bj`;
CREATE TABLE `bj` (
  `id` int(11) NOT NULL auto_increment,
  `bjname` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `bjname` (`bjname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL auto_increment,
  `sno` varchar(10) default NULL,
  `sname` varchar(10) default NULL,
  `sex` char(1) default NULL,
  `bjid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `sno` (`sno`),
  KEY `bjid` (`bjid`),
  CONSTRAINT `bjid` FOREIGN KEY (`bjid`) REFERENCES `bj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `bj` VALUES ('4', '空间16-1');
INSERT INTO `bj` VALUES ('5', '空间16-11');
INSERT INTO `bj` VALUES ('1', '网络工程16-1');
INSERT INTO `bj` VALUES ('3', '计测试16-1');
INSERT INTO `student` VALUES ('1', '111', '张三', '男', '1');
INSERT INTO `student` VALUES ('2', '222', '地方', '女', '3');
