/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : studentinfo

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2018-10-16 04:46:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL auto_increment,
  `sno` varchar(20) NOT NULL,
  `sname` varchar(20) default NULL,
  `sex` char(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '20092374', '刘晓梅', '女');
INSERT INTO `student` VALUES ('2', '20094355', '孙潇楠', '男');
INSERT INTO `student` VALUES ('3', '20094370', '杨玉', '女');
INSERT INTO `student` VALUES ('4', '20094371', '李泉泉', '男');
INSERT INTO `student` VALUES ('5', '20094376', '李东阳', '男');
INSERT INTO `student` VALUES ('6', '20094382', '沙苗苗', '女');
INSERT INTO `student` VALUES ('7', '20094383', '张翔宇', '男');
INSERT INTO `student` VALUES ('8', '20094388', '尹承明', '男');
INSERT INTO `student` VALUES ('9', '20094396', '肖爱芹', '女');
INSERT INTO `student` VALUES ('10', '20094399', '朱勇', '男');
INSERT INTO `student` VALUES ('11', '20094405', '辛兆阳', '男');
INSERT INTO `student` VALUES ('12', '20094409', '张鹏', '男');
INSERT INTO `student` VALUES ('13', '20094414', '昌腾腾', '男');
INSERT INTO `student` VALUES ('14', '20094419', '邢承彦', '男');
INSERT INTO `student` VALUES ('15', '20094423', '陈光永', '男');
INSERT INTO `student` VALUES ('16', '20094428', '柏浩', '男');
INSERT INTO `student` VALUES ('17', '20094438', '张钦超', '男');
INSERT INTO `student` VALUES ('18', '20094442', '李杰', '男');
INSERT INTO `student` VALUES ('19', '20094450', '杨翠霞', '女');
INSERT INTO `student` VALUES ('20', '20094451', '柴泽华', '男');
INSERT INTO `student` VALUES ('21', '20094455', '罗方勇', '男');
INSERT INTO `student` VALUES ('22', '20094459', '赵国栋', '男');
INSERT INTO `student` VALUES ('23', '20094464', '张友松', '男');
INSERT INTO `student` VALUES ('24', '20094467', '程艳丽', '女');
INSERT INTO `student` VALUES ('25', '20096785', '薛传宇', '男');
INSERT INTO `student` VALUES ('26', '20085072', '王志远', '男');
INSERT INTO `student` VALUES ('27', '20085104', '王连斌', '男');
INSERT INTO `student` VALUES ('28', '20091871', '郭洪志', '男');
INSERT INTO `student` VALUES ('29', '20094360', '冯贵胜', '男');
INSERT INTO `student` VALUES ('30', '20094364', '左振领', '男');
INSERT INTO `student` VALUES ('31', '20094365', '李洋', '女');
INSERT INTO `student` VALUES ('32', '20094372', '姜哲', '男');
INSERT INTO `student` VALUES ('33', '20094374', '贾娜', '女');
INSERT INTO `student` VALUES ('34', '20094384', '陈原', '男');
INSERT INTO `student` VALUES ('35', '20094386', '郑艳菡', '男');
INSERT INTO `student` VALUES ('36', '20094389', '王亚杰', '男');
INSERT INTO `student` VALUES ('37', '20094401', '赵德伟', '男');
INSERT INTO `student` VALUES ('38', '20094406', '王敬瑞', '男');
INSERT INTO `student` VALUES ('39', '20094416', '刘帅朋', '男');
INSERT INTO `student` VALUES ('40', '20094420', '陈道东', '男');
INSERT INTO `student` VALUES ('41', '20094424', '丛颖', '女');
INSERT INTO `student` VALUES ('42', '20094425', '盖晓', '男');
INSERT INTO `student` VALUES ('43', '20094429', '戴浩', '男');
INSERT INTO `student` VALUES ('44', '20094433', '杨林', '男');
INSERT INTO `student` VALUES ('45', '20094439', '殷丰升', '男');
INSERT INTO `student` VALUES ('46', '20094444', '尹瑞雪', '女');
INSERT INTO `student` VALUES ('47', '20094445', '马宝达', '男');
INSERT INTO `student` VALUES ('48', '20094452', '李程林', '男');
INSERT INTO `student` VALUES ('49', '20094456', '薛峰', '男');
INSERT INTO `student` VALUES ('50', '20094461', '赵瑞晓', '男');
INSERT INTO `student` VALUES ('51', '20096783', '谢欢', '男');
INSERT INTO `student` VALUES ('52', '20096786', '余泽华', '男');
