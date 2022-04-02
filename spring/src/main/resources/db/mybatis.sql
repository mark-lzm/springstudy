/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 23/03/2022 15:18:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(16, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'mt', 110.00);
INSERT INTO `account` VALUES (2, 'linda', 10000.00);

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` float(10, 1) NOT NULL COMMENT '商品定价',
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `pic` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `createtime` datetime NOT NULL COMMENT '生产日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES (1, '台式机', 3000.0, '该电脑质量非常好！！！！', NULL, '2015-02-03 13:22:53');
INSERT INTO `items` VALUES (2, '笔记本', 6000.0, '笔记本性能好，质量好！！！！！', NULL, '2015-02-09 13:22:57');
INSERT INTO `items` VALUES (3, '背包', 200.0, '名牌背包，容量大质量好！！！！', NULL, '2015-02-06 13:23:02');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `author_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `column_id` int NULL DEFAULT NULL,
  `column_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `comments_count` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_at` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `from_id` int NULL DEFAULT NULL,
  `post_id` int NULL DEFAULT NULL,
  `published_at` date NULL DEFAULT NULL,
  `store_at` date NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `views_count` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 0', NULL, NULL, NULL);
INSERT INTO `news` VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 1', NULL, NULL, NULL);
INSERT INTO `news` VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 2', NULL, NULL, NULL);
INSERT INTO `news` VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 3', NULL, NULL, NULL);
INSERT INTO `news` VALUES (5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 4', NULL, NULL, NULL);
INSERT INTO `news` VALUES (6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 5', NULL, NULL, NULL);
INSERT INTO `news` VALUES (7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 6', NULL, NULL, NULL);
INSERT INTO `news` VALUES (8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 7', NULL, NULL, NULL);
INSERT INTO `news` VALUES (9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 8', NULL, NULL, NULL);
INSERT INTO `news` VALUES (10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 9', NULL, NULL, NULL);
INSERT INTO `news` VALUES (11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 10', NULL, NULL, NULL);
INSERT INTO `news` VALUES (12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 11', NULL, NULL, NULL);
INSERT INTO `news` VALUES (13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 12', NULL, NULL, NULL);
INSERT INTO `news` VALUES (14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 13', NULL, NULL, NULL);
INSERT INTO `news` VALUES (15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 14', NULL, NULL, NULL);
INSERT INTO `news` VALUES (16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 15', NULL, NULL, NULL);
INSERT INTO `news` VALUES (17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 16', NULL, NULL, NULL);
INSERT INTO `news` VALUES (18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 17', NULL, NULL, NULL);
INSERT INTO `news` VALUES (19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 18', NULL, NULL, NULL);
INSERT INTO `news` VALUES (20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 19', NULL, NULL, NULL);
INSERT INTO `news` VALUES (21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 20', NULL, NULL, NULL);
INSERT INTO `news` VALUES (22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 21', NULL, NULL, NULL);
INSERT INTO `news` VALUES (23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 22', NULL, NULL, NULL);
INSERT INTO `news` VALUES (24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 23', NULL, NULL, NULL);
INSERT INTO `news` VALUES (25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 24', NULL, NULL, NULL);
INSERT INTO `news` VALUES (26, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 25', NULL, NULL, NULL);
INSERT INTO `news` VALUES (27, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 26', NULL, NULL, NULL);
INSERT INTO `news` VALUES (28, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 27', NULL, NULL, NULL);
INSERT INTO `news` VALUES (29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 28', NULL, NULL, NULL);
INSERT INTO `news` VALUES (30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 29', NULL, NULL, NULL);
INSERT INTO `news` VALUES (31, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 30', NULL, NULL, NULL);
INSERT INTO `news` VALUES (32, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 31', NULL, NULL, NULL);
INSERT INTO `news` VALUES (33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 32', NULL, NULL, NULL);
INSERT INTO `news` VALUES (34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 33', NULL, NULL, NULL);
INSERT INTO `news` VALUES (35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 34', NULL, NULL, NULL);
INSERT INTO `news` VALUES (36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 35', NULL, NULL, NULL);
INSERT INTO `news` VALUES (37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 36', NULL, NULL, NULL);
INSERT INTO `news` VALUES (38, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 37', NULL, NULL, NULL);
INSERT INTO `news` VALUES (39, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 38', NULL, NULL, NULL);
INSERT INTO `news` VALUES (40, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 39', NULL, NULL, NULL);
INSERT INTO `news` VALUES (41, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 40', NULL, NULL, NULL);
INSERT INTO `news` VALUES (42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 41', NULL, NULL, NULL);
INSERT INTO `news` VALUES (43, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 42', NULL, NULL, NULL);
INSERT INTO `news` VALUES (44, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 43', NULL, NULL, NULL);
INSERT INTO `news` VALUES (45, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 44', NULL, NULL, NULL);
INSERT INTO `news` VALUES (46, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 45', NULL, NULL, NULL);
INSERT INTO `news` VALUES (47, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 46', NULL, NULL, NULL);
INSERT INTO `news` VALUES (48, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 47', NULL, NULL, NULL);
INSERT INTO `news` VALUES (49, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 48', NULL, NULL, NULL);
INSERT INTO `news` VALUES (50, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 49', NULL, NULL, NULL);
INSERT INTO `news` VALUES (51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 50', NULL, NULL, NULL);
INSERT INTO `news` VALUES (52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 51', NULL, NULL, NULL);
INSERT INTO `news` VALUES (53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 52', NULL, NULL, NULL);
INSERT INTO `news` VALUES (54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 53', NULL, NULL, NULL);
INSERT INTO `news` VALUES (55, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 54', NULL, NULL, NULL);
INSERT INTO `news` VALUES (56, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 55', NULL, NULL, NULL);
INSERT INTO `news` VALUES (57, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 56', NULL, NULL, NULL);
INSERT INTO `news` VALUES (58, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 57', NULL, NULL, NULL);
INSERT INTO `news` VALUES (59, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 58', NULL, NULL, NULL);
INSERT INTO `news` VALUES (60, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 59', NULL, NULL, NULL);
INSERT INTO `news` VALUES (61, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 60', NULL, NULL, NULL);
INSERT INTO `news` VALUES (62, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 61', NULL, NULL, NULL);
INSERT INTO `news` VALUES (63, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 62', NULL, NULL, NULL);
INSERT INTO `news` VALUES (64, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 63', NULL, NULL, NULL);
INSERT INTO `news` VALUES (65, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 64', NULL, NULL, NULL);
INSERT INTO `news` VALUES (66, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 65', NULL, NULL, NULL);
INSERT INTO `news` VALUES (67, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 66', NULL, NULL, NULL);
INSERT INTO `news` VALUES (68, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 67', NULL, NULL, NULL);
INSERT INTO `news` VALUES (69, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 68', NULL, NULL, NULL);
INSERT INTO `news` VALUES (70, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 69', NULL, NULL, NULL);
INSERT INTO `news` VALUES (71, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 70', NULL, NULL, NULL);
INSERT INTO `news` VALUES (72, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 71', NULL, NULL, NULL);
INSERT INTO `news` VALUES (73, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 72', NULL, NULL, NULL);
INSERT INTO `news` VALUES (74, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 73', NULL, NULL, NULL);
INSERT INTO `news` VALUES (75, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 74', NULL, NULL, NULL);
INSERT INTO `news` VALUES (76, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 75', NULL, NULL, NULL);
INSERT INTO `news` VALUES (77, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 76', NULL, NULL, NULL);
INSERT INTO `news` VALUES (78, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 77', NULL, NULL, NULL);
INSERT INTO `news` VALUES (79, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 78', NULL, NULL, NULL);
INSERT INTO `news` VALUES (80, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 79', NULL, NULL, NULL);
INSERT INTO `news` VALUES (81, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 80', NULL, NULL, NULL);
INSERT INTO `news` VALUES (82, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 81', NULL, NULL, NULL);
INSERT INTO `news` VALUES (83, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 82', NULL, NULL, NULL);
INSERT INTO `news` VALUES (84, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 83', NULL, NULL, NULL);
INSERT INTO `news` VALUES (85, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 84', NULL, NULL, NULL);
INSERT INTO `news` VALUES (86, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 85', NULL, NULL, NULL);
INSERT INTO `news` VALUES (87, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 86', NULL, NULL, NULL);
INSERT INTO `news` VALUES (88, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 87', NULL, NULL, NULL);
INSERT INTO `news` VALUES (89, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 88', NULL, NULL, NULL);
INSERT INTO `news` VALUES (90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 89', NULL, NULL, NULL);
INSERT INTO `news` VALUES (91, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 90', NULL, NULL, NULL);
INSERT INTO `news` VALUES (92, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 91', NULL, NULL, NULL);
INSERT INTO `news` VALUES (93, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 92', NULL, NULL, NULL);
INSERT INTO `news` VALUES (94, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 93', NULL, NULL, NULL);
INSERT INTO `news` VALUES (95, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 94', NULL, NULL, NULL);
INSERT INTO `news` VALUES (96, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 95', NULL, NULL, NULL);
INSERT INTO `news` VALUES (97, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 96', NULL, NULL, NULL);
INSERT INTO `news` VALUES (98, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 97', NULL, NULL, NULL);
INSERT INTO `news` VALUES (99, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 98', NULL, NULL, NULL);
INSERT INTO `news` VALUES (100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 99', NULL, NULL, NULL);
INSERT INTO `news` VALUES (101, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 0', NULL, NULL, NULL);
INSERT INTO `news` VALUES (102, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 1', NULL, NULL, NULL);
INSERT INTO `news` VALUES (103, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 2', NULL, NULL, NULL);
INSERT INTO `news` VALUES (104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 3', NULL, NULL, NULL);
INSERT INTO `news` VALUES (105, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 4', NULL, NULL, NULL);
INSERT INTO `news` VALUES (106, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 5', NULL, NULL, NULL);
INSERT INTO `news` VALUES (107, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 6', NULL, NULL, NULL);
INSERT INTO `news` VALUES (108, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 7', NULL, NULL, NULL);
INSERT INTO `news` VALUES (109, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 8', NULL, NULL, NULL);
INSERT INTO `news` VALUES (110, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 9', NULL, NULL, NULL);
INSERT INTO `news` VALUES (111, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 10', NULL, NULL, NULL);
INSERT INTO `news` VALUES (112, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://img.36krcdn.com/20200410/v2_9c3331af67e64994aa97a27fffb1a380_img_png?x-oss-process=image/resize,m_mfit,w_520,h_300/crop,w_520,h_300,g_center', NULL, NULL, NULL, NULL, NULL, NULL, 'news 11', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `orders_id` int NOT NULL COMMENT '订单id',
  `items_id` int NOT NULL COMMENT '商品id',
  `items_num` int NULL DEFAULT NULL COMMENT '商品购买数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_orderdetail_1`(`orders_id` ASC) USING BTREE,
  INDEX `FK_orderdetail_2`(`items_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES (1, 3, 1, 1);
INSERT INTO `orderdetail` VALUES (2, 3, 2, 3);
INSERT INTO `orderdetail` VALUES (3, 4, 3, 4);
INSERT INTO `orderdetail` VALUES (4, 4, 2, 3);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '下单用户id',
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `createtime` datetime NOT NULL COMMENT '创建订单时间',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_orders_1`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (3, 1, '1000010', '2015-02-04 13:22:35', NULL);
INSERT INTO `orders` VALUES (4, 1, '1000011', '2015-02-03 13:22:41', NULL);
INSERT INTO `orders` VALUES (5, 10, '1000012', '2015-02-12 16:13:23', NULL);

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('mt', '6K0Ac3QTkvqIcg5yakKdug==', 'fhty8lOFvEZKJ+M8G7wO8w==', '2022-02-16 09:23:24');
INSERT INTO `persistent_logins` VALUES ('2023', 'eOu0MPV0HqKgCBJNAUbKrA==', 'yQlzPBHfUdBsSLYMmC+RUg==', '2022-02-28 02:22:46');
INSERT INTO `persistent_logins` VALUES ('2023', 'HCqe//xiTwE7ToHKV1GVrA==', 'Tglr1OdKl8GNUmwfolR+lQ==', '2022-02-28 06:53:11');
INSERT INTO `persistent_logins` VALUES ('mt', 'jan/yxfosUTZVVvxYgARkA==', 'IwtMpIFxjRD9Ph7sV8/huQ==', '2022-02-17 01:45:55');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'mt Wed Mar 23 14:22:48 CST 2022', '2022-01-18', 'f', '迪宝大厦', '$2a$10$kpNxe9MXh.ye738kUCLOnuhT.vNEnLrthOkSvj3B1jdxlyAWqWUa2', '18000000000');
INSERT INTO `user` VALUES ('10', '张三', '2014-07-09', '1', '北京市', NULL, NULL);
INSERT INTO `user` VALUES ('102', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('103', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('104', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('105', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('106', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('107', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('108', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('109', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('110', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('111', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('112', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('113', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('114', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('115', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('116', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('117', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('118', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('119', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('120', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('121', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('122', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('123', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('124', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('125', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('126', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('127', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('128', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('129', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('130', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('131', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('132', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('133', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('134', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('135', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('136', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('137', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('138', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('139', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('140', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('141', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('142', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('143', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('144', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('145', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('146', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('147', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('148', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('149', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('150', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('151', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('152', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('153', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('154', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('155', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('156', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('157', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('158', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('159', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('16', '张小明', NULL, '1', '河南郑州', NULL, NULL);
INSERT INTO `user` VALUES ('160', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('161', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('162', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('163', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('164', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('165', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('166', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('167', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('168', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('169', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('170', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('171', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('172', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('2', 'string', '2021-01-27', '1', 'string', 'string', 'string');
INSERT INTO `user` VALUES ('2020', 'mt123456', NULL, NULL, NULL, '123456', '123456789');
INSERT INTO `user` VALUES ('2021', '1234567', NULL, NULL, NULL, '123456', '123456');
INSERT INTO `user` VALUES ('2022', '123465', NULL, NULL, NULL, '123456', '123456');
INSERT INTO `user` VALUES ('2023', '123456789', NULL, NULL, NULL, '$2a$10$kpNxe9MXh.ye738kUCLOnuhT.vNEnLrthOkSvj3B1jdxlyAWqWUa2', '789123465');
INSERT INTO `user` VALUES ('2024', 'mt', '2022-03-22', 'm', 'dibao', '123456', '18000000000');
INSERT INTO `user` VALUES ('2025', 'mt', '2022-03-22', 'm', 'dibao', '123456', '18000000000');
INSERT INTO `user` VALUES ('211', 'mt45', '1990-10-10', 'm', '123', NULL, NULL);
INSERT INTO `user` VALUES ('212', 'mt45', '2990-10-10', 'm', '123', NULL, NULL);
INSERT INTO `user` VALUES ('213', 'mt46', '1990-10-10', 'm', '123', NULL, NULL);
INSERT INTO `user` VALUES ('214', 'mt47', '1990-10-10', 'm', '123', NULL, NULL);
INSERT INTO `user` VALUES ('22', '陈小明', NULL, '1', '河南郑州', NULL, NULL);
INSERT INTO `user` VALUES ('24', '张三丰', NULL, '1', '河南郑州', NULL, NULL);
INSERT INTO `user` VALUES ('25', '陈小明', NULL, '1', '河南郑州', NULL, NULL);
INSERT INTO `user` VALUES ('26', '王五', NULL, NULL, NULL, '$2a$10$O9TM4AkgZtRkK/..Dmi5Lenv4mUSkerdHwjwXr2FSQZFJhC1vUoQa', '18027215078');
INSERT INTO `user` VALUES ('3', 'string', '2021-01-27', '1', 'string', 'string', 'string');
INSERT INTO `user` VALUES ('300', 'mt', '2022-03-22', 'm', 'dibao', '123456', '18000000000');
INSERT INTO `user` VALUES ('301', 'mt', '2022-03-22', 'm', 'dibao', '123456', '18000000000');
INSERT INTO `user` VALUES ('44', 'mt', '2021-05-12', '1', 'dibaodasha', '123456', '123456');
INSERT INTO `user` VALUES ('45', 'mt', '2021-05-12', '1', 'dibaodasha', '123456', '123456');
INSERT INTO `user` VALUES ('46', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('47', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('48', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('49', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('50', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('51', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('52', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('53', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('54', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('55', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('56', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('57', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('58', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('59', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('60', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('61', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('62', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('63', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('64', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('65', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('66', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('67', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('68', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('69', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('70', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('71', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('72', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('73', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('74', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('75', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('76', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('77', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('78', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('79', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('80', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('81', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('82', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('83', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('84', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('85', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('86', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('87', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('88', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('89', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('90', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('91', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('92', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('93', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('94', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('95', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('96', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('97', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('98', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('99', 'mt', NULL, 'm', '迪宝大厦', '123456', '123456');
INSERT INTO `user` VALUES ('aecfb32d-a9a8-11ec-ba66-00ff7239723e', 'mt', '2022-03-22', 'm', 'dibao', '123456', '18000000000');

-- ----------------------------
-- Table structure for userconnection
-- ----------------------------
DROP TABLE IF EXISTS `userconnection`;
CREATE TABLE `userconnection`  (
  `sequence` int NULL DEFAULT NULL,
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `providerId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `providerUserId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `displayName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `profileUrl` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `imageUrl` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `accessToken` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `secret` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `refreshToken` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `expireTime` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`userId`, `providerId`, `providerUserId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userconnection
-- ----------------------------
INSERT INTO `userconnection` VALUES (1, '', 'qq', '123456', '123', '123', '123', '12', '123', '123', 123);
INSERT INTO `userconnection` VALUES (NULL, '', 'qq', '3456789', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userconnection` VALUES (NULL, '1', 'wechat', '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userconnection` VALUES (NULL, '2', 'wechat', '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userconnection` VALUES (1, '2023', 'custom', '1', 'mt', NULL, NULL, '77e1416f-b570-4cd8-9937-d71ab8e95d76', NULL, 'a9b455e3-e828-44fd-aab4-6181d8d8e8f4', 1645812843538);

-- ----------------------------
-- Table structure for uuid_user
-- ----------------------------
DROP TABLE IF EXISTS `uuid_user`;
CREATE TABLE `uuid_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of uuid_user
-- ----------------------------
INSERT INTO `uuid_user` VALUES ('', NULL);
INSERT INTO `uuid_user` VALUES ('172205ee-af53-46fd-94fa-9df7eeb654df', 'test uuidUser');
INSERT INTO `uuid_user` VALUES ('1cb11c67-f5c7-11eb-b362-00ff187a295d', 'test uuidUser');
INSERT INTO `uuid_user` VALUES ('3036203f-7767-11ec-95ad-84a938e24fca', 'random uuid');
INSERT INTO `uuid_user` VALUES ('31a7b6ea-f5c6-11eb-b362-00ff187a295d', 'test uuidUser');
INSERT INTO `uuid_user` VALUES ('39309b32-63d5-11ec-853d-00ff187a295d', 'java');
INSERT INTO `uuid_user` VALUES ('4db6f81a-f5c7-11eb-b362-00ff187a295d', 'test uuidUser');
INSERT INTO `uuid_user` VALUES ('5d687d6a-f5c7-11eb-b362-00ff187a295d', 'test uuidUser');
INSERT INTO `uuid_user` VALUES ('85332768-775e-11ec-95ad-84a938e24fca', 'random uuid');
INSERT INTO `uuid_user` VALUES ('94e25731-082e-43bc-8622-baebc501633a', 'java');
INSERT INTO `uuid_user` VALUES ('ec92bd4e-b2eb-11eb-8c30-00ff187a295d', '123');
INSERT INTO `uuid_user` VALUES ('f5a04fb6-f5b9-11eb-b362-00ff187a295d', 'test uuidUser');

SET FOREIGN_KEY_CHECKS = 1;
