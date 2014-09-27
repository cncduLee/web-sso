-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.19 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4796
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 websso 的数据库结构
CREATE DATABASE IF NOT EXISTS `websso` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `websso`;


-- 导出  表 websso.sys_dapartment 结构
CREATE TABLE IF NOT EXISTS `sys_dapartment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `name` varchar(100) DEFAULT NULL COMMENT '区域名称',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `parent_ids` (`parent_ids`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统部门表';

-- 正在导出表  websso.sys_dapartment 的数据：~0 rows (大约)
DELETE FROM `sys_dapartment`;
/*!40000 ALTER TABLE `sys_dapartment` DISABLE KEYS */;
INSERT INTO `sys_dapartment` (`id`, `parent_id`, `parent_ids`, `code`, `name`, `remarks`, `del_flag`) VALUES
	(1, 0, '{0}', '0', '企业', '企业顶级', '0');
/*!40000 ALTER TABLE `sys_dapartment` ENABLE KEYS */;


-- 导出  表 websso.sys_module 结构
CREATE TABLE IF NOT EXISTS `sys_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remarks` varchar(255) NOT NULL COMMENT '备注',
  `type` char(1) NOT NULL COMMENT '认证类型（0,1,2）',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0,1）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统模块表';

-- 正在导出表  websso.sys_module 的数据：~0 rows (大约)
DELETE FROM `sys_module`;
/*!40000 ALTER TABLE `sys_module` DISABLE KEYS */;
INSERT INTO `sys_module` (`id`, `name`, `remarks`, `type`, `del_flag`) VALUES
	(1, '单点登录系统', '单点登录系统模块', '0', '0');
/*!40000 ALTER TABLE `sys_module` ENABLE KEYS */;


-- 导出  表 websso.sys_resource 结构
CREATE TABLE IF NOT EXISTS `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `module` bigint(20) NOT NULL DEFAULT '0' COMMENT '模块ID（子系统）',
  `parent` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `type` char(1) NOT NULL DEFAULT '0' COMMENT '资源类型（0：菜单；1：按钮）',
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `href` varchar(255) NOT NULL COMMENT '链接',
  `target` varchar(20) NOT NULL COMMENT '目标（mainFrame、 _blank、_self、_parent、_top）',
  `icon` varchar(100) NOT NULL COMMENT '图标',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示（1：显示；0：不显示）',
  `permission` varchar(200) NOT NULL COMMENT '权限标识',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent`),
  KEY `parent_ids` (`parent_ids`),
  KEY `del_flag` (`del_flag`),
  KEY `module` (`module`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- 正在导出表  websso.sys_resource 的数据：~1 rows (大约)
DELETE FROM `sys_resource`;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;
INSERT INTO `sys_resource` (`id`, `module`, `parent`, `parent_ids`, `type`, `name`, `href`, `target`, `icon`, `sort`, `is_show`, `permission`, `del_flag`) VALUES
	(1, 1, 0, '0,', '0', '授权', '/aa', '_top', '/', 1, '0', 'user:authory:list', '0');
/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;


-- 导出  表 websso.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `module` bigint(20) NOT NULL COMMENT '所属模块',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- 正在导出表  websso.sys_role 的数据：~0 rows (大约)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `module`, `name`, `del_flag`) VALUES
	(1, 1, '管理员', '0');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


-- 导出  表 websso.sys_role_resource 结构
CREATE TABLE IF NOT EXISTS `sys_role_resource` (
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `resource_id` bigint(20) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与菜单关联表';

-- 正在导出表  websso.sys_role_resource 的数据：~0 rows (大约)
DELETE FROM `sys_role_resource`;
/*!40000 ALTER TABLE `sys_role_resource` DISABLE KEYS */;
INSERT INTO `sys_role_resource` (`role_id`, `resource_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `sys_role_resource` ENABLE KEYS */;


-- 导出  表 websso.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `department` bigint(20) NOT NULL COMMENT '部门编号',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注',
  `user_type` varchar(100) DEFAULT '' COMMENT '用户类型',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `salt` varchar(50) DEFAULT NULL COMMENT '加密用的盐',
  PRIMARY KEY (`id`),
  KEY `area_id` (`department`),
  KEY `login_name` (`login_name`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- 正在导出表  websso.sys_user 的数据：~1 rows (大约)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `department`, `login_name`, `password`, `name`, `email`, `phone`, `mobile`, `remarks`, `user_type`, `create_date`, `del_flag`, `login_ip`, `login_date`, `salt`) VALUES
	(1, 1, 'admin', '1bb97a7793962ef95a1edcc68d842fcc', '管理员', 's@s.com', '123', NULL, '', '', '2014-06-13 12:45:19', '0', NULL, NULL, 'f92d687c778df797a8c9d4c749627694');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- 导出  表 websso.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户与角色关联表';

-- 正在导出表  websso.sys_user_role 的数据：~0 rows (大约)
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
