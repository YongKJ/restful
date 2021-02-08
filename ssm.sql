/*
 Navicat Premium Data Transfer

 Source Server         : 我的阿里云
 Source Server Type    : MySQL
 Source Server Version : 100038
 Source Host           : 47.106.102.217:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 100038
 File Encoding         : 65001

 Date: 08/02/2021 11:46:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(5) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', 67, '韶关');
INSERT INTO `student` VALUES (2, '李四', 88, '清远');
INSERT INTO `student` VALUES (3, '王五', 99, '广州');
INSERT INTO `student` VALUES (4, '赵六', 77, '佛山');
INSERT INTO `student` VALUES (12, '小姐', 88, '上海');
INSERT INTO `student` VALUES (13, '费加罗', 100, '爱琴海');
INSERT INTO `student` VALUES (15, '大哥', 99, '深圳');
INSERT INTO `student` VALUES (16, '冷月', 78, '潘多拉');
INSERT INTO `student` VALUES (17, '魁拔', 99, '圣域');
INSERT INTO `student` VALUES (18, '天机', 52, '精灵岛');
INSERT INTO `student` VALUES (19, '李秋水', 90, '西夏皇宫');
INSERT INTO `student` VALUES (20, '静香', 88, '天堂岛');
INSERT INTO `student` VALUES (21, '月神', 96, '广寒界');

SET FOREIGN_KEY_CHECKS = 1;
