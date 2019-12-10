/*
MySQL Data Transfer
Source Host: localhost
Source Database: springjdbc
Target Host: localhost
Target Database: springjdbc
Date: 2017-11-15 10:26:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `content` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `article` VALUES ('2', 'title111', 'content111');
