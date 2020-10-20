/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2020-10-20 20:42:23
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
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'JavaEE');
INSERT INTO `course` VALUES ('2', 'Java基础');
INSERT INTO `course` VALUES ('3', 'Oracle数据库');

-- ----------------------------
-- Table structure for `husband`
-- ----------------------------
DROP TABLE IF EXISTS `husband`;
CREATE TABLE `husband` (
  `hname` varchar(20) DEFAULT NULL,
  `hid` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of husband
-- ----------------------------
INSERT INTO `husband` VALUES ('AAA', '1');
INSERT INTO `husband` VALUES ('BBB', '2');
INSERT INTO `husband` VALUES ('CCC', '3');

-- ----------------------------
-- Table structure for `middle`
-- ----------------------------
DROP TABLE IF EXISTS `middle`;
CREATE TABLE `middle` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studentid` int(10) DEFAULT NULL,
  `courseid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of middle
-- ----------------------------
INSERT INTO `middle` VALUES ('1', '1', '1');
INSERT INTO `middle` VALUES ('2', '1', '2');
INSERT INTO `middle` VALUES ('3', '1', '3');
INSERT INTO `middle` VALUES ('4', '2', '1');
INSERT INTO `middle` VALUES ('5', '2', '3');

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
-- Table structure for `newslabel`
-- ----------------------------
DROP TABLE IF EXISTS `newslabel`;
CREATE TABLE `newslabel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newslabel
-- ----------------------------
INSERT INTO `newslabel` VALUES ('1', '娱乐新闻', '0');
INSERT INTO `newslabel` VALUES ('2', '体育新闻', '0');
INSERT INTO `newslabel` VALUES ('3', 'NBA', '2');
INSERT INTO `newslabel` VALUES ('4', 'CBA', '2');
INSERT INTO `newslabel` VALUES ('5', '火箭', '3');
INSERT INTO `newslabel` VALUES ('6', '湖人', '3');
INSERT INTO `newslabel` VALUES ('7', '青岛双星', '4');
INSERT INTO `newslabel` VALUES ('8', '八一南昌', '4');
INSERT INTO `newslabel` VALUES ('9', '浙江广厦', '4');
INSERT INTO `newslabel` VALUES ('10', '明星八卦', '1');
INSERT INTO `newslabel` VALUES ('11', '电视剧', '1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三');
INSERT INTO `student` VALUES ('2', '李四');

-- ----------------------------
-- Table structure for `wife`
-- ----------------------------
DROP TABLE IF EXISTS `wife`;
CREATE TABLE `wife` (
  `wname` varchar(20) DEFAULT NULL,
  `wid` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wife
-- ----------------------------
INSERT INTO `wife` VALUES ('aaa', '1');
INSERT INTO `wife` VALUES ('bbb', '2');
INSERT INTO `wife` VALUES ('ccc', '3');
