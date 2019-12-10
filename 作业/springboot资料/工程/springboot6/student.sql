/*
MySQL Data Transfer
Source Host: localhost
Source Database: student
Target Host: localhost
Target Database: student
Date: 2019/10/29 9:33:35
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
INSERT INTO `bj` VALUES ('11', '999');
INSERT INTO `bj` VALUES ('8', '物联网17');
INSERT INTO `bj` VALUES ('4', '空间16-14');
INSERT INTO `student` VALUES ('3', '333', '333', '女', '4');
INSERT INTO `student` VALUES ('4', '888', '556', '男', '8');
