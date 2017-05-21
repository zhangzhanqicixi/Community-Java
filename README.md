# 大学社团管理系统
帮一个学弟写的社团管理系统，后端框架有 Struts2, Hibernate, Spring, 前端框架用到了国产开源的DWZ UI

## 功能介绍
本系统分为学生，管理员，社长三种角色

系统主页包括网站首页、网站简介、**站内新闻**、**社团浏览**、**社团活动**，**用户评论**，**图片上传**等功能

后台管理页面分为管理员和社长两部分，根据登录的账号密码划分

具体页面见最后图

## 数据库建表

一共需要建7张表：

* community --- 社团管理表
* community_activity --- 社团活动表
* community_member --- 社团成员表
* community_user --- 用户表
* community_web_info --- 网站信息表
* community_web_message --- 用户评论表
* community_web_news --- 新闻表

建表语句如下：

```

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : community

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 05/21/2017 18:54:29 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `community`
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `community_name` varchar(100) DEFAULT '' COMMENT '社团名称',
  `community_introduction` varchar(255) DEFAULT '' COMMENT '社团简介',
  `community_img_path` varchar(255) DEFAULT '' COMMENT '社团图片路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `community_activity`
-- ----------------------------
DROP TABLE IF EXISTS `community_activity`;
CREATE TABLE `community_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_title` varchar(255) DEFAULT '' COMMENT '活动标题',
  `activity_content` varchar(255) DEFAULT '' COMMENT '活动内容',
  `community_id` int(11) DEFAULT '0' COMMENT '社团id',
  `start_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `community_member`
-- ----------------------------
DROP TABLE IF EXISTS `community_member`;
CREATE TABLE `community_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '成员userId',
  `community_id` int(11) DEFAULT NULL COMMENT '社团id',
  `member_status` int(11) DEFAULT '0' COMMENT '0：未加入；1：已加入',
  `member_type` int(11) DEFAULT '1' COMMENT '1：学生；2：社团管理员（社长）；3：管理员',
  `member_apply_reason` varchar(255) DEFAULT NULL COMMENT '申请理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `community_user`
-- ----------------------------
DROP TABLE IF EXISTS `community_user`;
CREATE TABLE `community_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '名字',
  `user_id` varchar(100) NOT NULL DEFAULT '' COMMENT '学号',
  `user_tel` varchar(100) NOT NULL DEFAULT '' COMMENT '电话',
  `user_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `community_web_info`
-- ----------------------------
DROP TABLE IF EXISTS `community_web_info`;
CREATE TABLE `community_web_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `introduction` text NOT NULL COMMENT '简介',
  `tel` varchar(255) NOT NULL COMMENT '联系我们',
  `addres` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `community_web_message`
-- ----------------------------
DROP TABLE IF EXISTS `community_web_message`;
CREATE TABLE `community_web_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户主键',
  `content` varchar(255) NOT NULL DEFAULT '' COMMENT '留言内容',
  `news_id` int(11) DEFAULT NULL COMMENT '对应的新闻id',
  `insert_time` datetime DEFAULT NULL COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `community_web_news`
-- ----------------------------
DROP TABLE IF EXISTS `community_web_news`;
CREATE TABLE `community_web_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主页信息',
  `news_title` varchar(100) NOT NULL DEFAULT '' COMMENT '新闻标题',
  `news_content` text NOT NULL COMMENT '新闻内容',
  `user_id` int(11) NOT NULL COMMENT '发布者id',
  `insert_time` datetime DEFAULT NULL COMMENT '发布时间',
  `news_img_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;


```


## 部分截图
![homepage](https://github.com/zhangzhanqicixi/community/raw/dev/img/1.png)
![homepage](https://github.com/zhangzhanqicixi/community/raw/dev/img/2.png)
![homepage](https://github.com/zhangzhanqicixi/community/raw/dev/img/3.png)
![homepage](https://github.com/zhangzhanqicixi/community/raw/dev/img/4.png)
![homepage](https://github.com/zhangzhanqicixi/community/raw/dev/img/5.png)
![homepage](https://github.com/zhangzhanqicixi/community/raw/dev/img/6.png)















