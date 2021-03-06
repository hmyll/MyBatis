/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2020-10-13 19:01:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'China');
INSERT INTO `country` VALUES ('2', 'USA');

-- ----------------------------
-- Table structure for `minister`
-- ----------------------------
DROP TABLE IF EXISTS `minister`;
CREATE TABLE `minister` (
  `mid` int(10) NOT NULL AUTO_INCREMENT,
  `mname` varchar(20) DEFAULT NULL,
  `countryid` int(10) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of minister
-- ----------------------------
INSERT INTO `minister` VALUES ('1', 'aa', '1');
INSERT INTO `minister` VALUES ('2', 'bb', '1');
INSERT INTO `minister` VALUES ('3', 'cc', '1');
INSERT INTO `minister` VALUES ('4', 'dd', '2');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('3', '李明', '20', '8');
INSERT INTO `student` VALUES ('5', '王五', '20', '8');
INSERT INTO `student` VALUES ('6', '王五', '20', '8');
INSERT INTO `student` VALUES ('7', '王五', '20', '8');
INSERT INTO `student` VALUES ('8', '王五', '20', '8');
INSERT INTO `student` VALUES ('9', '王五', '20', '8');
INSERT INTO `student` VALUES ('10', '王五', '20', '8');
INSERT INTO `student` VALUES ('11', '王五', '20', '8');
INSERT INTO `student` VALUES ('12', '王五', '20', '8');
INSERT INTO `student` VALUES ('13', '王五', '20', '8');
INSERT INTO `student` VALUES ('14', '王五', '20', '8');
INSERT INTO `student` VALUES ('15', '王五', '20', '8');
INSERT INTO `student` VALUES ('16', '王五', '20', '8');
INSERT INTO `student` VALUES ('17', '王五', '20', '8');
INSERT INTO `student` VALUES ('18', '王五', '20', '8');
INSERT INTO `student` VALUES ('19', '王五', '20', '8');
INSERT INTO `student` VALUES ('20', '王五', '20', '8');
INSERT INTO `student` VALUES ('21', '王五', '20', '8');
INSERT INTO `student` VALUES ('22', '王五', '20', '8');
INSERT INTO `student` VALUES ('23', '王五', '20', '8');
INSERT INTO `student` VALUES ('24', '王五', '20', '8');
INSERT INTO `student` VALUES ('25', '王五', '20', '8');
INSERT INTO `student` VALUES ('26', '王五', '20', '8');
INSERT INTO `student` VALUES ('27', '王五', '20', '8');
INSERT INTO `student` VALUES ('28', '王五', '20', '8');
INSERT INTO `student` VALUES ('29', '王五', '20', '8');
INSERT INTO `student` VALUES ('30', '王五', '20', '8');
INSERT INTO `student` VALUES ('31', '王五', '20', '8');
INSERT INTO `student` VALUES ('32', '王五', '20', '8');
INSERT INTO `student` VALUES ('33', '王五', '20', '8');
INSERT INTO `student` VALUES ('34', '王五', '20', '8');
INSERT INTO `student` VALUES ('35', '王五', '20', '8');
INSERT INTO `student` VALUES ('36', '王五', '20', '8');
INSERT INTO `student` VALUES ('37', '王五', '20', '8');
INSERT INTO `student` VALUES ('38', '王五', '20', '8');
INSERT INTO `student` VALUES ('39', '王五', '20', '8');
INSERT INTO `student` VALUES ('40', '王五', '20', '8');
INSERT INTO `student` VALUES ('41', '张三', '20', '98.5');
INSERT INTO `student` VALUES ('42', '张三', '20', '98.5');
