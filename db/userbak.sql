/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : jason

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 13/04/2019 15:58:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'id',
  `username` varchar(255) DEFAULT NULL COMMENT '名称',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `customerid` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'jason', 11, 11111, NULL);
INSERT INTO `user` VALUES (2, 'nancy', 12, 22222, '2019-04-11 21:12:48');
INSERT INTO `user` VALUES (3, 'shencheng', 13, 133, '2019-04-11 21:13:15');
INSERT INTO `user` VALUES (7, 'shencheng', 10, 3141, '2019-08-12 12:12:13');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
