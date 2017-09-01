/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : zy_video

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-22 09:44:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL,
  `login_pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `course_descr` varchar(255) DEFAULT NULL COMMENT '课程简介',
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('7', '前端开发与Git入门', 'Git是一款免费、开源的分布式版本控制系统，用于敏捷高效地处理任何或小或大的项目。经过本章课程学习你将轻松入门，学会使用Git管理自己的源代码，让自己的开发之路井井有条，想进一步学习Git进阶部分的同学可报名智游前端开发课程。', null, '2017-07-25 11:20:24', '1');
INSERT INTO `course` VALUES ('8', '每天20分钟轻松入门React', '适合有一定HTML+JS基础、想学习React的同学。本课程循序渐进、浅显易懂，非常适合React入门学习。想进一步学习和使用React进行开发的同学可以报名智游前端开发课程。', null, '2017-07-25 11:20:21', '1');
INSERT INTO `course` VALUES ('9', 'UI基础入门', '适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名智游UI设计课程。', null, '2017-07-25 11:20:19', '6');
INSERT INTO `course` VALUES ('11', 'Python编程零基础入门', '适合无编程基础但想学Python的同学学习。本课程完全零基础入门，如果希望深入学习Python开发可报名学习智游Python企业开发课程。', null, '2017-07-25 11:20:16', '10');
INSERT INTO `course` VALUES ('13', '轻松进击PHP基础', '适合无编程基础但想学PHP开发的同学学习。本课程零基础入门，学习完本节课程相信同学们都轻松入门PHP开发，如果希望深入学习PHP开发可报名学习智游PHP课程，资深”老司机”带你完成PHP大牛的进阶之路！', null, '2017-07-25 11:20:15', '11');

-- ----------------------------
-- Table structure for speaker
-- ----------------------------
DROP TABLE IF EXISTS `speaker`;
CREATE TABLE `speaker` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `speaker_name` varchar(30) DEFAULT NULL,
  `speaker_job` varchar(30) DEFAULT NULL,
  `speaker_head_url` varchar(255) DEFAULT NULL,
  `speaker_descr` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of speaker
-- ----------------------------
INSERT INTO `speaker` VALUES ('8', '张强', '高级讲师', 'http://vod.zhiyou100.com/gkk/teacher/zq.jpg', '高级工程师，曾供职于多家公司，参与过多个企业级项目研发。对H5、iOS客户端开发及混合开发有深入的研究，熟悉PHP等服务端技术，有着多年的开发经验和教学经验。', null, '2017-07-25 16:32:12');
INSERT INTO `speaker` VALUES ('9', '田原惠子', '高级讲师', 'http://vod.zhiyou100.com/gkk/teacher/tyhz.jpg\r\n', 'Aotodesk国际认证动画师，精通架构设计、效果图表达、APP特效等。多年产品经理经验。  代表作品：《手机博物馆》，《诺客商城》、《途铂旅行》。', null, '2017-07-25 16:32:10');
INSERT INTO `speaker` VALUES ('10', '邢志勇', '高级讲师', 'http://vod.zhiyou100.com/gkk/teacher/xzy.jpg\r\n', '5年应用及平台开发经验，主导并参与多款商业、非商业性质软件的研发工作，精通Web前端、Python服务端、iOS手机App研发、VR开发、Unity3D开发等技术。', null, '2017-07-25 16:32:08');
INSERT INTO `speaker` VALUES ('11', '宋玮', '高级讲师', 'http://vod.zhiyou100.com/gkk/teacher/sw.jpg\r\n', '多年PHP开发经验，参与过多个WEB项目开发，带领团队开发过CRM系统、OA系统、项目管理系统、SEM平台。精通PHP及多款开发框架、MySQL集群、Linux服务器运维、H5前端开发。', null, '2017-07-25 16:32:05');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) DEFAULT NULL COMMENT '学科名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学科表信息，只使用数据，不在页面中维护';

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', 'WEB前端');
INSERT INTO `subject` VALUES ('2', 'Java');
INSERT INTO `subject` VALUES ('3', 'Android');
INSERT INTO `subject` VALUES ('4', 'IOS');
INSERT INTO `subject` VALUES ('5', '大数据');
INSERT INTO `subject` VALUES ('6', 'UI');
INSERT INTO `subject` VALUES ('7', 'VR');
INSERT INTO `subject` VALUES ('8', 'U3D');
INSERT INTO `subject` VALUES ('9', '人工智能');
INSERT INTO `subject` VALUES ('10', 'Python');
INSERT INTO `subject` VALUES ('11', 'PHP');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` int(11) DEFAULT '0' COMMENT '性别，2女1男',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱，唯一，登录账号',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `captcha` varchar(20) DEFAULT NULL COMMENT '验证码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='前台注册用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '1', '2000-01-01', 'zhouyanchao@foxmail.com', '湖南', '长沙', 'upload/1500603909300_head.jpeg', '96e79218965eb72c92a549dd5a330112', '2017-07-20 10:23:27', '2017-07-20 15:23:50', '55235');
INSERT INTO `user` VALUES ('2', null, '0', null, 'zhang@126.com', null, null, null, '980ac217c6b51e7dc41040bec1edfec8', '2017-07-21 16:35:58', '2017-07-21 16:35:58', null);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_title` varchar(255) DEFAULT NULL COMMENT '视频标题',
  `speaker_id` int(11) DEFAULT NULL COMMENT '主讲人id',
  `course_id` int(11) DEFAULT NULL COMMENT '所属课程id',
  `video_length` int(11) DEFAULT NULL,
  `video_image_url` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `video_descr` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `video_play_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '前端开发环境搭建', '7', '6', '562', 'http://vod.zhiyou100.com/gkk/h5/c1/image/01.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/01.mp4', '前端开发环境的搭建，包括前端常用开发工具介绍、VS Code下载安装，以及前端开发常用运行工具--浏览器的介绍、Firefox下载安装等内容。帮助大家准备好前端开发环境以便深入学习后续小项目', null, '2017-08-18 13:50:11', '434');
INSERT INTO `video` VALUES ('2', 'HTML页面基本结构', '9', '6', '596', 'http://vod.zhiyou100.com/gkk/h5/c1/image/02.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/01.mp4', '前端开发主要技术和在项目中的作用、HTML标签基本结构、HTML文档基本结构、字符编码问题及开发一个简单的页面。', null, '2017-07-26 11:13:03', '368');
INSERT INTO `video` VALUES ('3', '认识线性图标', '9', '9', '1421', 'http://vod.zhiyou100.com/gkk/ui/c1/image/01.jpg', 'http://vod.zhiyou100.com/gkk/ui/c1/01.mp4', '初识UI，本节课主要讲解UI设计及产品经理课程中的第一小节：线性图标设计，包括：图标的定义、图标的用途分类、线性图标的设计原则，最后老师还给大家布置了一个有趣的作业，聪明机智的你来一起学习吧！', null, null, '378');
INSERT INTO `video` VALUES ('4', '新闻页面开发', '7', '6', '1374', 'http://vod.zhiyou100.com/gkk/h5/c1/image/03.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/03.mp4', ' 新闻页面的开发，包括前端开发中最常用的HTML标签：H1、P、DIV、SPAN、IMG、A等，还包括控制文字、图片、超链接等最常用的CSS样式。', null, '2017-07-26 10:29:58', '333');
INSERT INTO `video` VALUES ('5', '了解PHP', '11', '13', '1268', 'http://vod.zhiyou100.com/gkk/php/c1/image/01.jpg', 'http://vod.zhiyou100.com/gkk/php/c1/01.mp4', '讲解了PHP的基本概述，帮助大家对PHP语言有一个大体的认知，包括：什么是PHP、PHP的优势、智游教育的PHP课程、Lamp与wamp的介绍、开发环境和开发工具的的配置、PHP基本语法。', null, null, '342');
INSERT INTO `video` VALUES ('6', 'React快速体验-组件', '8', '8', '907', 'http://vod.zhiyou100.com/gkk/h5/c3/image/01.jpg', 'http://vod.zhiyou100.com/gkk/h5/c3/01.mp4', '介绍了React的前生今世，让同学们了解库文件下载和整体的React项目结构及React库最简单的使用。', null, '2017-08-21 09:23:09', '193');
INSERT INTO `video` VALUES ('7', '个人主页项目开发-1', '7', '6', '1692', 'http://vod.zhiyou100.com/gkk/h5/c1/image/05-1.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/05-1.mp4', '个人主页项目的演示、页面结构分析、包括网页常见的构成：页头、LOGO、横幅、导航、主体、页脚等。在页头开发过程中使用了固定位置、定宽居中等常见的布局模式。', null, null, '284');
INSERT INTO `video` VALUES ('8', 'React创建组件的方法', '8', '8', '749', 'http://vod.zhiyou100.com/gkk/h5/c3/image/02.jpg', 'http://vod.zhiyou100.com/gkk/h5/c3/02.mp4', '详细介绍了最简单的React组件的创建、使用及组件之间的简单嵌套使用。', null, null, '165');
INSERT INTO `video` VALUES ('9', 'ES6重写组件和生命周期', '8', '8', '1195', 'http://vod.zhiyou100.com/gkk/h5/c3/image/03.jpg', 'http://vod.zhiyou100.com/gkk/h5/c3/03.mp4', '使用ES6语法重写React组件，更简洁的语法，更清晰的思路，同时介绍了React组件的生命周期。', null, null, '188');
INSERT INTO `video` VALUES ('10', '个人主页项目开发-2', '7', '6', '1699', 'http://vod.zhiyou100.com/gkk/h5/c1/image/05-2.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/05-2.mp4', '个人主页项目页面主体部分的开发，大量使用了定宽居中的技术，在我的同学部分还使用了相对定位、绝对定位等非常重要定位技术，还使用了圆形边框等CSS3新技术。', null, null, '266');
INSERT INTO `video` VALUES ('11', '使用JSX创建组件', '8', '8', '1414', 'http://vod.zhiyou100.com/gkk/h5/c3/image/04.jpg', 'http://vod.zhiyou100.com/gkk/h5/c3/04.mp4', '使用JSX重写React单一组件、组合组件，了解React的组件化思想及JSX的使用。', null, null, '263');
INSERT INTO `video` VALUES ('12', '个人主页项目开发-3', '7', '6', '409', 'http://vod.zhiyou100.com/gkk/h5/c1/image/05-3.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/05-3.mp4', '个人主页的语义化重构。介绍了H5语义化的意义、将非语义化的DIV+CSS改造成语义化标签的具体实践过程。以及VS Code分割视图在开发中的应用。', null, '2017-07-26 10:30:06', '237');
INSERT INTO `video` VALUES ('13', 'React虚拟DOM', '8', '8', '1468', 'http://vod.zhiyou100.com/gkk/h5/c3/image/05.jpg', 'http://vod.zhiyou100.com/gkk/h5/c3/05.mp4', 'React的快速响应魅力所在——虚拟DOM，本节课详细比较了普通DOM和虚拟DOM的区别。', null, null, '250');
INSERT INTO `video` VALUES ('14', '个人简历项目开发-1', '7', '6', '2112', 'http://vod.zhiyou100.com/gkk/h5/c1/image/06-1.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/06-1.mp4', '个人简历项目的开发。RGB颜色简介，字体简介及安装。本案例重度使用定位技术，使用了CSS3中新增的旋转图形变换技术。以及一些高级CSS选择器。', null, null, '232');
INSERT INTO `video` VALUES ('15', '个人简历项目开发-2', '7', '6', '1997', 'http://vod.zhiyou100.com/gkk/h5/c1/image/06-2.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/06-2.mp4\"', '个人简历项目开发的第二部分，包括字体的使用（注意：实际开发中会使用更高级的技术来使用字体）、背景图片的控制、内容溢出控制、绝对定位元素的层次控制、半透明的使用等。', null, null, '206');
INSERT INTO `video` VALUES ('16', '场景秀项目开发-1', '7', '6', '1569', 'http://vod.zhiyou100.com/gkk/h5/c1/image/07-1.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/07-1.mp4', '场景秀项目是一个手机页面、本部分介绍了响应式开发环境、viewport在响应式开发中的应用、vw/vh等响应式CSS单位的使用、CSS函数calc()在单位混合计算时的使用。', null, null, '218');
INSERT INTO `video` VALUES ('17', '场景秀项目开发-2', '7', '6', '2179', 'http://vod.zhiyou100.com/gkk/h5/c1/image/07-2.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/07-2.mp4', '场景秀动画部分的开发、本部分是场景秀开发的最出彩最重要的部分。包括关键帧动画的定义、平移动画、绽放动画等动画效果的实现方法。H5音频及JS控制音乐播放暂停。', null, null, '223');
INSERT INTO `video` VALUES ('18', 'Git的安装及配置', '7', '7', '320', 'http://vod.zhiyou100.com/gkk/h5/c2/image/01.jpg', 'http://vod.zhiyou100.com/gkk/h5/c2/01.mp4', '介绍了Git的强大之处：保存开发过程、实验新特性而不破坏现有数据、多人合作开发、分布式思想、没网也可以使用，详细的讲解了Git的下载方法和安装注意事项。', null, null, '208');
INSERT INTO `video` VALUES ('19', '使用Git记录开发过程', '7', '7', '1024', 'http://vod.zhiyou100.com/gkk/h5/c2/image/02.jpg', 'http://vod.zhiyou100.com/gkk/h5/c2/02.mp4', '详细操作了使用Git管理源代码，包括：初始化、从工作区添加到暂存区、从暂存区添加到持久区等Git命令，同时介绍了Git的文件结构、撤回功能。', null, null, '158');
INSERT INTO `video` VALUES ('20', '响应式登录页面项目开发', '7', '6', '2134', 'http://vod.zhiyou100.com/gkk/h5/c1/image/08.jpg', 'http://vod.zhiyou100.com/gkk/h5/c1/08.mp4', '响应式页面开发与移动端适配，重点内容包括vw/vh单位、媒体查询的介绍及在移动端适配中的应用方法。表单及INPUT标签的基本使用和使用CSS控制表单样式的方法等。', null, null, '244');
INSERT INTO `video` VALUES ('21', '使用码云作为远程代码库', '7', '7', '385', 'http://vod.zhiyou100.com/gkk/h5/c2/image/03.jpg', 'http://vod.zhiyou100.com/gkk/h5/c2/03.mp4', '介绍了码云的使用，注册账号并登录，配置SSH公钥。', null, null, '171');
INSERT INTO `video` VALUES ('22', '与远程代码库同步', '7', '7', '355', 'http://vod.zhiyou100.com/gkk/h5/c2/image/04.jpg', 'http://vod.zhiyou100.com/gkk/h5/c2/04.mp4', '详细讲解在码云上面创建自己的项目并克隆到本地，使用Git命令将本地代码提交到远程仓库等内容。', null, null, '221');
INSERT INTO `video` VALUES ('23', 'Python运行环境下载', '10', '11', '350', 'http://vod.zhiyou100.com/gkk/python/c1/image/01.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/01.mp4', 'Python开发环境的搭建，Python的下载及安装，帮助大家准备好Python开发环境。', null, null, '243');
INSERT INTO `video` VALUES ('24', 'Python运行环境安装', '10', '11', '239', 'http://vod.zhiyou100.com/gkk/python/c1/image/02.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/02.mp4', 'Windows操作系统下面Python环境的安装及注意事项。', null, null, '178');
INSERT INTO `video` VALUES ('25', 'IDLE的基本使用', '10', '11', '1149', 'http://vod.zhiyou100.com/gkk/python/c1/image/03.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/03.mp4', 'Python自带编辑器IDLE的使用，初识Python的语法，简单语法的编写和运行。', null, null, '193');
INSERT INTO `video` VALUES ('26', 'Sublime的基本使用', '10', '11', '565', 'http://vod.zhiyou100.com/gkk/python/c1/image/04.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/04.mp4', 'Sublime的安装及基本使用，主要介绍了Sublime的智能提示功能，常用操作，例如新建文件、保存文件、字体设置、窗口背景颜色等。', null, null, '166');
INSERT INTO `video` VALUES ('27', 'Print语句', '10', '11', '805', 'http://vod.zhiyou100.com/gkk/python/c1/image/05.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/05.mp4', '讲解Python中的语句概述，主要介绍了常用的Print语句，语法错误的解决，以及注释的写法。', null, null, '192');
INSERT INTO `video` VALUES ('28', '变量', '10', '11', '332', 'http://vod.zhiyou100.com/gkk/python/c1/image/06.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/06.mp4', '介绍了Python语法中的变量写法、使用以及变量命名中的注意事项。', null, null, '270');
INSERT INTO `video` VALUES ('29', '运算符', '10', '11', '667', 'http://vod.zhiyou100.com/gkk/python/c1/image/07.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/07.mp4', '讲解Python中运算符的基本使用，主要有算数运算符、比较运算符，介绍了三个双引号注释多行代码，', null, null, '209');
INSERT INTO `video` VALUES ('30', 'If条件语句', '10', '11', '1099', 'http://vod.zhiyou100.com/gkk/python/c1/image/08.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/08.mp4', '讲解Python中的if条件语句，利用if语句进行简单的出租车价格计算。', null, null, '193');
INSERT INTO `video` VALUES ('31', 'While循环', '10', '11', '1024', 'http://vod.zhiyou100.com/gkk/python/c1/image/09.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/09.mp4', '介绍Python编程中的while循环语句的基本形式，语句格式等。', null, null, '185');
INSERT INTO `video` VALUES ('32', 'For循环', '10', '11', '1085', 'http://vod.zhiyou100.com/gkk/python/c1/image/10.jpg', 'http://vod.zhiyou100.com/gkk/python/c1/10.mp4', '讲解Python中的for循环，简单介绍了for循环的简单使用及语句格式。', null, null, '168');
