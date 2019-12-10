/*
MySQL Data Transfer
Source Host: localhost
Source Database: student
Target Host: localhost
Target Database: student
Date: 2018/10/11 11:13:38
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for bj
-- ----------------------------
DROP TABLE IF EXISTS `bj`;
CREATE TABLE `bj` (
  `id` int(11) NOT NULL auto_increment,
  `bjname` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
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
-- Records 
-- ----------------------------
INSERT INTO `bj` VALUES ('1', '网络工程');
INSERT INTO `student` VALUES ('1', '001', '张三', '男', '1');
