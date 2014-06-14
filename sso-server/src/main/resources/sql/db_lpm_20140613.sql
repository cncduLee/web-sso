-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.0.22-community-nt - MySQL Community Edition (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2014-06-13 16:50:34
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for websso
DROP DATABASE IF EXISTS `websso`;
CREATE DATABASE IF NOT EXISTS `websso` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `websso`;


-- Dumping structure for table websso.sys_dapartment
DROP TABLE IF EXISTS `sys_dapartment`;
CREATE TABLE IF NOT EXISTS `sys_dapartment` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `code` varchar(100) default NULL COMMENT '区域编码',
  `name` varchar(100) default NULL COMMENT '区域名称',
  `remarks` varchar(255) default NULL COMMENT '备注',
  `del_flag` char(1) default '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY  (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `parent_ids` (`parent_ids`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统部门表';

-- Dumping data for table websso.sys_dapartment: ~1 rows (approximately)
DELETE FROM `sys_dapartment`;
/*!40000 ALTER TABLE `sys_dapartment` DISABLE KEYS */;
INSERT INTO `sys_dapartment` (`id`, `parent_id`, `parent_ids`, `code`, `name`, `remarks`, `del_flag`) VALUES
	(1, 0, '{0}', '0', '企业', '企业顶级', '0');
/*!40000 ALTER TABLE `sys_dapartment` ENABLE KEYS */;


-- Dumping structure for table websso.sys_module
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE IF NOT EXISTS `sys_module` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `remarks` varchar(255) NOT NULL COMMENT '备注',
  `type` char(1) NOT NULL COMMENT '认证类型（0,1,2）',
  `del_flag` char(1) NOT NULL default '0' COMMENT '删除标记（0,1）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统模块表';

-- Dumping data for table websso.sys_module: ~1 rows (approximately)
DELETE FROM `sys_module`;
/*!40000 ALTER TABLE `sys_module` DISABLE KEYS */;
INSERT INTO `sys_module` (`id`, `name`, `remarks`, `type`, `del_flag`) VALUES
	(1, '单点登录系统', '单点登录系统模块', '0', '0');
/*!40000 ALTER TABLE `sys_module` ENABLE KEYS */;


-- Dumping structure for table websso.sys_resource
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE IF NOT EXISTS `sys_resource` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '编号',
  `parent` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `type` char(1) NOT NULL default '0' COMMENT '资源类型（0：菜单；1：按钮）',
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `href` varchar(255) NOT NULL COMMENT '链接',
  `target` varchar(20) NOT NULL COMMENT '目标（mainFrame、 _blank、_self、_parent、_top）',
  `icon` varchar(100) NOT NULL COMMENT '图标',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示（1：显示；0：不显示）',
  `permission` varchar(200) NOT NULL COMMENT '权限标识',
  `del_flag` char(1) default '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY  (`id`),
  KEY `parent_id` (`parent`),
  KEY `parent_ids` (`parent_ids`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- Dumping data for table websso.sys_resource: ~1 rows (approximately)
DELETE FROM `sys_resource`;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;
INSERT INTO `sys_resource` (`id`, `parent`, `parent_ids`, `type`, `name`, `href`, `target`, `icon`, `sort`, `is_show`, `permission`, `del_flag`) VALUES
	(1, 0, '0,', '0', '授权', '/aa', '_top', '/', 1, '0', 'user:authory:list', '0');
/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;


-- Dumping structure for table websso.sys_role
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '编号',
  `module` bigint(20) NOT NULL COMMENT '所属模块',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `del_flag` char(1) default '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY  (`id`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- Dumping data for table websso.sys_role: ~1 rows (approximately)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `module`, `name`, `del_flag`) VALUES
	(1, 1, '管理员', '0');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


-- Dumping structure for table websso.sys_role_resource
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE IF NOT EXISTS `sys_role_resource` (
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `resource_id` bigint(20) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY  (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与菜单关联表';

-- Dumping data for table websso.sys_role_resource: ~1 rows (approximately)
DELETE FROM `sys_role_resource`;
/*!40000 ALTER TABLE `sys_role_resource` DISABLE KEYS */;
INSERT INTO `sys_role_resource` (`role_id`, `resource_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `sys_role_resource` ENABLE KEYS */;


-- Dumping structure for table websso.sys_user
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '编号',
  `department` bigint(20) NOT NULL COMMENT '部门编号',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) default NULL COMMENT '密码',
  `name` varchar(100) default NULL COMMENT '姓名',
  `email` varchar(200) default NULL COMMENT '邮箱',
  `phone` varchar(200) default NULL COMMENT '电话',
  `mobile` varchar(200) default NULL COMMENT '手机',
  `remarks` varchar(255) default '' COMMENT '备注',
  `user_type` varchar(100) default '' COMMENT '用户类型',
  `create_date` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) default '0' COMMENT '删除标记（0：正常；1：删除）',
  `login_ip` varchar(100) default NULL COMMENT '最后登陆IP',
  `login_date` datetime default NULL COMMENT '最后登陆时间',
  PRIMARY KEY  (`id`),
  KEY `area_id` (`department`),
  KEY `login_name` (`login_name`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- Dumping data for table websso.sys_user: ~1 rows (approximately)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `department`, `login_name`, `password`, `name`, `email`, `phone`, `mobile`, `remarks`, `user_type`, `create_date`, `del_flag`, `login_ip`, `login_date`) VALUES
	(1, 1, 'admin', 'admin', '管理员', 's@s.com', '123', NULL, '', '', '2014-06-13 12:45:19', '0', NULL, NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- Dumping structure for table websso.sys_user_role
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY  (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户与角色关联表';

-- Dumping data for table websso.sys_user_role: ~1 rows (approximately)
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
