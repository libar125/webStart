/*
 Navicat Premium Data Transfer

 Source Server         : 139.155.235.122
 Source Server Type    : MySQL
 Source Server Version : 50736 (5.7.36)
 Source Host           : 139.155.235.122:3306
 Source Schema         : web_start

 Target Server Type    : MySQL
 Target Server Version : 50736 (5.7.36)
 File Encoding         : 65001

 Date: 24/08/2023 15:31:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for biz_book
-- ----------------------------
DROP TABLE IF EXISTS `biz_book`;
CREATE TABLE `biz_book`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `category` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别（功法、阵法、炼器、炼丹、符箓）',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '所属',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '秘籍书籍' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of biz_book
-- ----------------------------
INSERT INTO `biz_book` VALUES (1, '太虚剑气', '功法', 1, NULL, '2022-09-16 14:15:08', NULL, '2022-09-16 14:15:08');
INSERT INTO `biz_book` VALUES (2, '阴阳八卦阵', '阵法', 1, NULL, '2022-09-16 14:17:23', NULL, '2022-09-16 14:17:23');
INSERT INTO `biz_book` VALUES (3, '无上自在功', '功法', 7, NULL, '2022-09-16 14:18:38', NULL, '2022-09-16 14:18:38');
INSERT INTO `biz_book` VALUES (4, '八阵图', '阵法', 7, NULL, '2022-09-16 14:19:24', NULL, '2022-09-16 14:19:24');
INSERT INTO `biz_book` VALUES (5, '万剑归宗', '功法', 7, NULL, '2022-09-16 14:19:45', NULL, '2022-09-16 14:19:45');
INSERT INTO `biz_book` VALUES (6, '太虚剑神', '功法', 2, NULL, '2022-09-16 14:20:39', NULL, '2022-09-16 14:20:39');
INSERT INTO `biz_book` VALUES (7, '飞烬玄灵', '功法', 2, NULL, '2022-09-16 14:21:17', NULL, '2022-09-16 14:21:17');
INSERT INTO `biz_book` VALUES (8, '千星破', '符箓', 2, NULL, '2022-09-16 14:24:10', NULL, '2022-09-16 14:24:10');
INSERT INTO `biz_book` VALUES (9, '上善若水', '炼器', 4, NULL, '2022-09-16 14:25:51', NULL, '2022-09-16 14:25:51');
INSERT INTO `biz_book` VALUES (10, '百裂无影', '炼器', 4, NULL, '2022-09-16 14:27:19', NULL, '2022-09-16 14:27:19');
INSERT INTO `biz_book` VALUES (11, '天道无极', '功法', 4, NULL, '2022-09-16 14:28:49', NULL, '2022-09-16 14:28:49');

-- ----------------------------
-- Table structure for sys_base
-- ----------------------------
DROP TABLE IF EXISTS `sys_base`;
CREATE TABLE `sys_base`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_base
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint(20) NOT NULL COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父部门id',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `level` tinyint(1) NULL DEFAULT NULL COMMENT '层级（1 根目录 2 单位 3 部门）',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '太虚剑派', 1, NULL, '2022-09-14 14:28:18', NULL, '2022-09-14 14:28:18', 0);
INSERT INTO `sys_dept` VALUES (2, 1, '剑神峰', 2, NULL, '2022-09-14 14:30:26', NULL, '2022-09-14 14:30:26', 0);
INSERT INTO `sys_dept` VALUES (3, 2, '剑心堂', 3, NULL, '2022-09-14 14:32:28', NULL, '2022-09-14 14:32:28', 0);
INSERT INTO `sys_dept` VALUES (4, 2, '剑形堂', 3, NULL, '2022-09-14 14:32:46', NULL, '2022-09-14 14:32:46', 0);
INSERT INTO `sys_dept` VALUES (5, 2, '剑意堂', 3, NULL, '2022-09-14 14:32:52', NULL, '2022-09-14 14:32:52', 0);
INSERT INTO `sys_dept` VALUES (6, 2, '剑魂堂', 3, NULL, '2022-09-14 14:32:57', NULL, '2022-09-14 14:32:57', 0);
INSERT INTO `sys_dept` VALUES (7, 2, '剑神堂', 3, NULL, '2022-09-14 14:33:02', NULL, '2022-09-14 14:33:02', 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典名称',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典代码',
  `value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典值',
  `is_type` tinyint(1) NULL DEFAULT NULL COMMENT '是否是字典类型（1 字典类型 2 字典项）',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL,
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ip',
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题，操作方法描述',
  `method` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情',
  `state` tinyint(4) NULL DEFAULT NULL COMMENT '状态',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL COMMENT '菜单ID',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `sort` int(11) NULL DEFAULT 0 COMMENT '显示顺序',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '访问路径',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件名称',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `state` tinyint(1) NULL DEFAULT 1 COMMENT '菜单状态（1正常 2停用 3删除）',
  `perms` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `visible` tinyint(1) NULL DEFAULT 0 COMMENT '显示状态（0 显示 1隐藏）',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `active_menu` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统设置', 1, 'Layout', 'system', 'M', 1, 'system', 0, 'system', NULL, NULL, NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', 1, '/system/user', 'user', 'C', 1, 'system:user:view', 0, 'user', NULL, NULL, NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (3, 1, '部门管理', 1, '/system/dept', 'dept', 'C', 1, 'system:dept:view', 0, 'dept', NULL, NULL, NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (4, 1, '角色管理', 2, '/system/role', 'role', 'C', 1, 'system:role:view', 0, 'role', NULL, NULL, NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (5, 1, '菜单管理', 3, '/system/menu', 'menu', 'C', 1, 'system:menu:view', 0, 'menu', NULL, NULL, NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (6, 1, '字典管理', 4, '/system/dict', 'dict', 'C', 1, 'system:dict:view', 0, 'dict', NULL, NULL, NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (7, 1, '安全设置', 5, '/system/safe', 'safe', 'C', 1, 'system:safe:view', 0, 'safe', NULL, '', NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 1, '用户日志', 6, '/system/log', 'log', 'C', 1, 'system:log:view', 0, 'log', NULL, '', NULL, '2022-09-14 13:54:24', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 2, '新增', 1, NULL, NULL, 'F', 1, 'system:user:add', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 2, '修改', 2, NULL, NULL, 'F', 1, 'system:user:update', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 2, '删除', 3, NULL, NULL, 'F', 1, 'system:user:delete', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 2, '修改密码', 4, NULL, NULL, 'F', 1, 'system:user:updatePassword', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 3, '新增', 1, NULL, NULL, 'F', 1, 'system:dept:add', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 3, '修改', 2, NULL, NULL, 'F', 1, 'system:dept:update', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 3, '删除', 3, NULL, NULL, 'F', 1, 'system:dept:delete', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 4, '新增', 1, NULL, NULL, 'F', 1, 'system:role:add', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 4, '修改', 2, NULL, NULL, 'F', 1, 'system:role:update', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 4, '删除', 3, NULL, NULL, 'F', 1, 'system:role:delete', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 5, '新增', 1, NULL, NULL, 'F', 1, 'system:menu:add', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 5, '修改', 2, NULL, NULL, 'F', 1, 'system:menu:update', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 5, '删除', 3, NULL, NULL, 'F', 1, 'system:menu:delete', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 6, '新增', 1, NULL, NULL, 'F', 1, 'system:dict:add', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 6, '修改', 2, NULL, NULL, 'F', 1, 'system:dict:update', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 6, '删除', 3, NULL, NULL, 'F', 1, 'system:dict:delete', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 7, '修改', 1, NULL, NULL, 'F', 1, 'system:safe:update', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 1, '书籍管理', 6, '/business/book', 'book', 'C', 1, 'business:book:view', 0, 'book', NULL, '', NULL, '2022-09-16 14:10:58', NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 26, '新增', 1, NULL, NULL, 'F', 1, 'business:book:add', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (28, 26, '修改', 2, NULL, NULL, 'F', 1, 'business:book:update', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_menu` VALUES (29, 26, '删除', 3, NULL, NULL, 'F', 1, 'business:book:delete', 0, '#', NULL, NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL COMMENT '角色ID',
  `role_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符',
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `is_open` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树是否展开（0折叠 1展开 ）',
  `data_scope` tinyint(1) NULL DEFAULT NULL COMMENT '数据范围（1 所有数据 2 所在部门及子部门数据 3 所在部门数据 4 仅本人数据 5 自定义数据）',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ZZ', '宗主', 1, 1, NULL, NULL, '2022-09-14 14:25:07', NULL, '2022-09-14 14:25:07', 0);
INSERT INTO `sys_role` VALUES (2, 'ZL', '长老', 1, 1, NULL, NULL, '2022-09-14 14:38:35', NULL, '2022-09-14 14:38:35', 0);
INSERT INTO `sys_role` VALUES (3, 'FZ', '峰主', 1, 2, NULL, NULL, '2022-09-14 14:36:48', NULL, '2022-09-14 14:36:48', 0);
INSERT INTO `sys_role` VALUES (4, 'TZ', '堂主', 1, 3, NULL, NULL, '2022-09-14 14:37:12', NULL, '2022-09-14 14:37:12', 0);
INSERT INTO `sys_role` VALUES (5, 'PTDZ', '普通弟子', 1, 4, NULL, NULL, '2022-09-21 13:57:40', NULL, '2022-09-21 13:57:40', 0);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门关联表（当角色数据范围为自定义数据时使用）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '角色菜单关联' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 14);
INSERT INTO `sys_role_menu` VALUES (1, 15);
INSERT INTO `sys_role_menu` VALUES (1, 16);
INSERT INTO `sys_role_menu` VALUES (1, 17);
INSERT INTO `sys_role_menu` VALUES (1, 18);
INSERT INTO `sys_role_menu` VALUES (1, 19);
INSERT INTO `sys_role_menu` VALUES (1, 20);
INSERT INTO `sys_role_menu` VALUES (1, 21);
INSERT INTO `sys_role_menu` VALUES (1, 22);
INSERT INTO `sys_role_menu` VALUES (1, 23);
INSERT INTO `sys_role_menu` VALUES (1, 24);
INSERT INTO `sys_role_menu` VALUES (1, 25);
INSERT INTO `sys_role_menu` VALUES (1, 26);
INSERT INTO `sys_role_menu` VALUES (1, 27);
INSERT INTO `sys_role_menu` VALUES (1, 28);
INSERT INTO `sys_role_menu` VALUES (1, 29);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (2, 6);
INSERT INTO `sys_role_menu` VALUES (2, 7);
INSERT INTO `sys_role_menu` VALUES (2, 8);
INSERT INTO `sys_role_menu` VALUES (2, 9);
INSERT INTO `sys_role_menu` VALUES (2, 10);
INSERT INTO `sys_role_menu` VALUES (2, 11);
INSERT INTO `sys_role_menu` VALUES (2, 12);
INSERT INTO `sys_role_menu` VALUES (2, 13);
INSERT INTO `sys_role_menu` VALUES (2, 14);
INSERT INTO `sys_role_menu` VALUES (2, 15);
INSERT INTO `sys_role_menu` VALUES (2, 16);
INSERT INTO `sys_role_menu` VALUES (2, 17);
INSERT INTO `sys_role_menu` VALUES (2, 18);
INSERT INTO `sys_role_menu` VALUES (2, 19);
INSERT INTO `sys_role_menu` VALUES (2, 20);
INSERT INTO `sys_role_menu` VALUES (2, 21);
INSERT INTO `sys_role_menu` VALUES (2, 22);
INSERT INTO `sys_role_menu` VALUES (2, 23);
INSERT INTO `sys_role_menu` VALUES (2, 24);
INSERT INTO `sys_role_menu` VALUES (2, 25);
INSERT INTO `sys_role_menu` VALUES (2, 26);
INSERT INTO `sys_role_menu` VALUES (2, 27);
INSERT INTO `sys_role_menu` VALUES (2, 28);
INSERT INTO `sys_role_menu` VALUES (2, 29);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (3, 2);
INSERT INTO `sys_role_menu` VALUES (3, 3);
INSERT INTO `sys_role_menu` VALUES (3, 4);
INSERT INTO `sys_role_menu` VALUES (3, 5);
INSERT INTO `sys_role_menu` VALUES (3, 6);
INSERT INTO `sys_role_menu` VALUES (3, 7);
INSERT INTO `sys_role_menu` VALUES (3, 8);
INSERT INTO `sys_role_menu` VALUES (3, 9);
INSERT INTO `sys_role_menu` VALUES (3, 10);
INSERT INTO `sys_role_menu` VALUES (3, 11);
INSERT INTO `sys_role_menu` VALUES (3, 12);
INSERT INTO `sys_role_menu` VALUES (3, 13);
INSERT INTO `sys_role_menu` VALUES (3, 14);
INSERT INTO `sys_role_menu` VALUES (3, 15);
INSERT INTO `sys_role_menu` VALUES (3, 16);
INSERT INTO `sys_role_menu` VALUES (3, 17);
INSERT INTO `sys_role_menu` VALUES (3, 18);
INSERT INTO `sys_role_menu` VALUES (3, 19);
INSERT INTO `sys_role_menu` VALUES (3, 20);
INSERT INTO `sys_role_menu` VALUES (3, 21);
INSERT INTO `sys_role_menu` VALUES (3, 22);
INSERT INTO `sys_role_menu` VALUES (3, 23);
INSERT INTO `sys_role_menu` VALUES (3, 24);
INSERT INTO `sys_role_menu` VALUES (3, 25);
INSERT INTO `sys_role_menu` VALUES (3, 26);
INSERT INTO `sys_role_menu` VALUES (3, 27);
INSERT INTO `sys_role_menu` VALUES (3, 28);
INSERT INTO `sys_role_menu` VALUES (3, 29);
INSERT INTO `sys_role_menu` VALUES (4, 1);
INSERT INTO `sys_role_menu` VALUES (4, 2);
INSERT INTO `sys_role_menu` VALUES (4, 3);
INSERT INTO `sys_role_menu` VALUES (4, 4);
INSERT INTO `sys_role_menu` VALUES (4, 5);
INSERT INTO `sys_role_menu` VALUES (4, 6);
INSERT INTO `sys_role_menu` VALUES (4, 7);
INSERT INTO `sys_role_menu` VALUES (4, 8);
INSERT INTO `sys_role_menu` VALUES (4, 9);
INSERT INTO `sys_role_menu` VALUES (4, 10);
INSERT INTO `sys_role_menu` VALUES (4, 11);
INSERT INTO `sys_role_menu` VALUES (4, 12);
INSERT INTO `sys_role_menu` VALUES (4, 13);
INSERT INTO `sys_role_menu` VALUES (4, 14);
INSERT INTO `sys_role_menu` VALUES (4, 15);
INSERT INTO `sys_role_menu` VALUES (4, 16);
INSERT INTO `sys_role_menu` VALUES (4, 17);
INSERT INTO `sys_role_menu` VALUES (4, 18);
INSERT INTO `sys_role_menu` VALUES (4, 19);
INSERT INTO `sys_role_menu` VALUES (4, 20);
INSERT INTO `sys_role_menu` VALUES (4, 21);
INSERT INTO `sys_role_menu` VALUES (4, 22);
INSERT INTO `sys_role_menu` VALUES (4, 23);
INSERT INTO `sys_role_menu` VALUES (4, 24);
INSERT INTO `sys_role_menu` VALUES (4, 25);
INSERT INTO `sys_role_menu` VALUES (4, 26);
INSERT INTO `sys_role_menu` VALUES (5, 1);
INSERT INTO `sys_role_menu` VALUES (5, 2);
INSERT INTO `sys_role_menu` VALUES (5, 3);
INSERT INTO `sys_role_menu` VALUES (5, 4);
INSERT INTO `sys_role_menu` VALUES (5, 5);
INSERT INTO `sys_role_menu` VALUES (5, 6);
INSERT INTO `sys_role_menu` VALUES (5, 7);
INSERT INTO `sys_role_menu` VALUES (5, 8);
INSERT INTO `sys_role_menu` VALUES (5, 26);

-- ----------------------------
-- Table structure for sys_safe
-- ----------------------------
DROP TABLE IF EXISTS `sys_safe`;
CREATE TABLE `sys_safe`  (
  `id` bigint(20) NOT NULL,
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `pwd_cycle` int(11) NULL DEFAULT NULL COMMENT '密码更改周期（90天，60天，30天，0无）',
  `pwd_login_limit` tinyint(1) NULL DEFAULT NULL COMMENT '密码登录限制（0：连续错3次，锁定账号15分钟。1：连续错5次，锁定账号30分钟）',
  `idle_time_setting` tinyint(1) NULL DEFAULT NULL COMMENT '闲置时间设置（0：无。1：空闲30分钟，系统默认用户退出）',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_safe
-- ----------------------------
INSERT INTO `sys_safe` VALUES (1, NULL, '2022-09-14 14:23:33', NULL, '2022-09-14 14:23:33', 30, 1, 1, 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL COMMENT '用户编号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '所属部门',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `update_pwd_time` datetime NULL DEFAULT NULL COMMENT '密码更改时间',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0=>未删除 1=>已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'chiyuan', '赤鸢', 1, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (2, 'fuhua', '符华', 2, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (3, 'chenyi', '陈怡', 3, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (4, 'mingyue', '明月', 3, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (5, 'chenglixue', '程立雪', 4, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (6, 'baiye', '白夜', 4, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (7, 'yunmo', '云墨', 4, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (8, 'chiling', '炽翎', 5, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (9, 'xunyu', '迅羽', 6, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (10, 'cangxuan', '苍玄', 5, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (11, 'danzhu', '丹朱', 5, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (12, 'lisushang', '李素裳', 7, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (13, 'liuqinghan', '柳清寒', 7, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (14, 'luoshen', '洛神', 7, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (15, 'yeqingchen', '叶轻尘', 7, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (16, 'zhaohanshuang', '赵寒霜', 7, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (17, 'fenghua', '风华', 6, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (18, 'qianduo', '钱朵朵', 6, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (19, 'liuhongye', '刘虹叶', 6, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `sys_user` VALUES (20, 'fengling', '风灵', 3, '718e2f66813bb6f1', '386f25e43ae6272ee97e7bf8ebdbb4f0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '用户角色关联' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (6, 2);
INSERT INTO `sys_user_role` VALUES (2, 3);
INSERT INTO `sys_user_role` VALUES (7, 4);
INSERT INTO `sys_user_role` VALUES (8, 4);
INSERT INTO `sys_user_role` VALUES (9, 4);
INSERT INTO `sys_user_role` VALUES (14, 4);
INSERT INTO `sys_user_role` VALUES (20, 4);
INSERT INTO `sys_user_role` VALUES (3, 5);
INSERT INTO `sys_user_role` VALUES (4, 5);
INSERT INTO `sys_user_role` VALUES (5, 5);
INSERT INTO `sys_user_role` VALUES (10, 5);
INSERT INTO `sys_user_role` VALUES (11, 5);
INSERT INTO `sys_user_role` VALUES (12, 5);
INSERT INTO `sys_user_role` VALUES (13, 5);
INSERT INTO `sys_user_role` VALUES (15, 5);
INSERT INTO `sys_user_role` VALUES (16, 5);
INSERT INTO `sys_user_role` VALUES (17, 5);
INSERT INTO `sys_user_role` VALUES (18, 5);
INSERT INTO `sys_user_role` VALUES (19, 5);

SET FOREIGN_KEY_CHECKS = 1;
