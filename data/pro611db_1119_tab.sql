/*
 Navicat Premium Data Transfer

 Source Server         : osx
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : pro611db

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 11/19/2017 03:48:34 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bptzz_course`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_course`;
CREATE TABLE `bptzz_course` (
  `course_id` varchar(255) NOT NULL,
  `day` varchar(255) DEFAULT NULL,
  `end_time` int(11) NOT NULL,
  `start_time` int(11) NOT NULL,
  `course_link` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) NOT NULL,
  `credits` int(11) NOT NULL,
  `ref_textbook` varchar(255) DEFAULT NULL,
  `term` varchar(255) NOT NULL,
  `textbook` varchar(255) DEFAULT NULL,
  `course_department` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FKl0boh08b9erv0326p978aab07` (`course_department`),
  CONSTRAINT `FKl0boh08b9erv0326p978aab07` FOREIGN KEY (`course_department`) REFERENCES `bptzz_department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bptzz_course`
-- ----------------------------
BEGIN;
INSERT INTO `bptzz_course` VALUES ('BI4001', 'MONDAY', '5', '4', null, 'Protein Structure and Function', '2', 'Protein Structure and Function', 'FALL', null, '4'), ('BI4002', 'FRIDAY', '3', '2', null, 'Proteomics and Biological Mass Spectrometry', '2', 'Proteomics and Biological Mass Spectrometry', 'WINTER', null, '4'), ('BI4003', 'TUESDAY', '3', '2', null, 'Biotechnology Entrepreneurship', '2', 'Biotechnology Entrepreneurship', 'SUMMER', null, '4'), ('BI4004', 'TUESDAY;THURESDAY', '8', '7', null, 'Finance in a Global Perspective', '2', 'Finance in a Global Perspective', 'FALL', null, '4'), ('BI4005', 'FRIDAY', '6', '5', null, 'Clinical Biochemistry', '2', 'Clinical Biochemistry', 'INTER', null, '4'), ('BI4006', 'TUESDAY', '3', '2', null, 'Human Physiology and Mechanisms of Disease', '2', 'Human Physiology and Mechanisms of Disease', 'INTER', null, '4'), ('BI4007', 'WEDNESDAY', '9', '8', null, 'Biochemistry and Cell Biology of Lipids and Membranes', '2', null, 'SUMMER', null, '4'), ('BI4008', 'WEDNESDAY', '6', '5', null, 'Proteomics and Biological Mass Spectrometry', '2', null, 'WINTER', null, '4'), ('BU2001', 'MONDAY;WEDNESDAY', '9', '2', null, 'MARKETING', '2', 'MARKETING', 'WINTER', null, '2'), ('BU2002', 'TUESDAY;THURSDAY', '3', '2', null, 'International Business', '2', null, 'FALL', null, '2'), ('BU2003', 'FRIDAY', '3', '2', null, 'Managing Employees', '2', 'Managing Employees', 'SUMMER', null, '2'), ('BU2004', 'TUESDAY', '3', '2', null, 'Quantitative Studies', '2', null, 'SUMMER', null, '2'), ('BU2005', 'THURSDAY', '8', '7', null, 'Leadership and Organizational Change', '2', 'Leadership and Organizational Change', 'WINTER', null, '2'), ('BU2006', 'MONDAY', '3', '2', null, 'Accounting Concepts and Techniques', '2', 'Accounting Concepts and Techniques', 'FALL', null, '2'), ('BU2007', 'TUESDAY', '2', '2', null, 'Corporate Governance', '2', null, 'FALL', null, '2'), ('BU2008', 'MONDAY;FRIDAY', '2', '1', null, 'Consolidated Financial Statements', '2', null, 'WINTER', null, '2'), ('CH5001', 'TUESDAY', '7', '6', null, ' X-ray Crystallography', '2', null, 'INTER', null, '5'), ('CH5002', 'MONDAY', '8', '7', null, 'Advanced DNA Science', '2', 'Advanced DNA Science', 'SUMMER', null, '5'), ('CH5003', 'FRIDAY', '7', '6', null, 'Analytical Toxicology', '2', 'Analytical Toxicology', 'FALL', null, '5'), ('CH5004', 'TUESDAY', '7', '6', null, 'Directed Special Studies', '2', null, 'WINTER', null, '5'), ('CH5005', 'MONDAY', '6', '5', null, 'Advanced Topics in Organic Syntheses', '2', null, 'SUMMER', null, '5'), ('CH5006', 'THURESDAY', '8', '4', null, 'Current Topics in Organic Chemistry', '2', 'Current Topics in Organic Chemistry', 'FALL', null, '5'), ('CH5007', 'FRIDAY', '6', '5', null, 'Selected Topics in Inorganic Chemistry', '2', null, 'FALL', null, '5'), ('CH5008', 'MONDAY', '6', '5', null, 'Special Topics in Theoretical Chemistry', '2', 'Special Topics in Theoretical Chemistry', 'WINTER', null, '5'), ('CS1001', 'MONDAY;WEDNESDAY', '2', '1', null, 'C PROGRAMMING', '2', null, 'FALL', null, '1'), ('CS1002', 'FRIDAY', '3', '2', null, 'UNIX', '2', 'UNIX', 'WINTER', null, '1'), ('CS1003', 'MONDAY;WEDNESDAY', '6', '3', null, 'DATABASE SYSTEM', '2', null, 'FALL', null, '1'), ('CS1004', 'TUESDAY;THURSDAY', '8', '3', null, 'ARTIFICIAL INTELLIGENCE', '2', 'ARTIFICIAL INTELLIGENCE', 'SUMMER', null, '1'), ('CS1005', 'TUESDAY;THURSDAY', '5', '2', null, 'SYSTEMS ANALYSIS AND DESIGN', '2', null, 'FALL', null, '1'), ('CS1006', 'MONDAY', '2', '1', null, 'NETWORKING', '2', 'NETWORKING', 'WINTER', null, '1'), ('CS1007', 'TUESDAY', '8', '7', null, 'DISK OPERATING SYSTEM', '2', 'DISK OPERATING SYSTEM', 'FALL', null, '1'), ('CS1008', 'THURSDAY', '7', '2', null, 'COMPUTER HARDWARE', '2', null, 'WINTER', null, '1'), ('ED6001', 'MONDAY;TUESDAY;WEDNESDAY;THURSDAY;FRIDAY', '5', '3', null, 'Research in Education', '4', 'Educational', 'WINTER', null, '6'), ('ED6002', 'THURESDAY', '7', '6', null, 'Approaches to Literacy Development', '2', null, 'FALL', null, '6'), ('ED6003', 'MONDAY', '7', '6', null, 'Comparative and International Education', '2', null, 'WINTER', null, '6'), ('ED6004', 'FRIDAY', '9', '8', null, 'Educational Policy Analysis', '2', null, 'FALL', null, '6'), ('ED6005', 'MONDAY', '6', '5', null, 'Fundamentals of Curriculum Theory and Development', '2', null, 'INTER', null, '6'), ('ED6006', 'TUESDAY;FRIDAY', '7', '6', null, 'Issues in Education   ', '2', null, 'SUMMER', null, '6'), ('ED6007', 'WEDNESDAY;THURESDAY', '6', '5', null, 'Sociological Aspects of Education', '2', 'Sociological Aspects of Education', 'FALL', null, '6'), ('ED6008', 'FRIDAY', '3', '2', null, 'Final Project Seminar', '4', null, 'SUMMER/INTER', null, '6'), ('MA3001', 'MONDAY;TUESDAY;FRIDAY', '8', '2', null, 'Abstract Algebra ', '2', 'Abstract Algebra ', 'WINTER', null, '3'), ('MA3002', 'THURSDAY;FRIDAY', '2', '2', null, 'Advanced Linear Programming', '2', 'Advanced Linear Programming', 'FALL', null, '3'), ('MA3003', 'FRIDAY', '2', '2', null, 'Integer Programming', '2', 'Integer Programming', 'FALL', null, '3'), ('MA3004', 'TUESDAY', '8', '7', null, 'Combinatorial Optimization', '2', 'Combinatorial Optimization', 'WINTER', null, '3'), ('MA3005', 'MONDAY', '7', '6', null, 'Seminar', '2', null, 'SUMMER', null, '3'), ('MA3006', 'MONDAY;FRIDAY', '9', '8', null, 'General Topology ', '2', 'General Topology ', 'FALL', null, '3'), ('MA3007', 'FRIDAY', '7', '6', null, 'Multivariate Analysis', '2', null, 'FALL', null, '3'), ('MA3008', 'MONDAY', '6', '4', null, 'Experimental Design', '2', null, 'WINTER', null, '3');
COMMIT;

-- ----------------------------
--  Table structure for `bptzz_department`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_department`;
CREATE TABLE `bptzz_department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `UK_5qwmvawlymrl778rmp4pf7ynn` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bptzz_department`
-- ----------------------------
BEGIN;
INSERT INTO `bptzz_department` VALUES ('4', 'Biological'), ('2', 'Business'), ('5', 'Chemistry'), ('1', 'Computer Science'), ('6', 'Education'), ('3', 'Mathematics');
COMMIT;

-- ----------------------------
--  Table structure for `bptzz_question`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_question`;
CREATE TABLE `bptzz_question` (
  `question_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `optiona` varchar(255) NOT NULL,
  `optionb` varchar(255) NOT NULL,
  `optionc` varchar(255) NOT NULL,
  `optiond` varchar(255) NOT NULL,
  `question_course` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `UK_daw433lexmurssxbubyqcf8a4` (`content`),
  KEY `FKtpjlemwfwng60cdo2988dls6s` (`question_course`),
  CONSTRAINT `FKtpjlemwfwng60cdo2988dls6s` FOREIGN KEY (`question_course`) REFERENCES `bptzz_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bptzz_question`
-- ----------------------------
BEGIN;
INSERT INTO `bptzz_question` VALUES ('2', 'B', 'Which of the following have the fastest access time?', 'Magnetic Tapes', 'Semiconductor Memories', 'Compact Disks', 'Magnetic Disks', 'CS1002'), ('3', 'B', 'What does ASCII stand for ?', 'American Scientific Code for Internet Institute', 'American Standard Code for Information Interchange', '  African Standard Currency II', 'None of these', 'CS1002'), ('4', 'D', 'Which of the following IT firms develop processors', 'Infosys', 'Wipro', 'SNOY', 'AMD', 'CS1002'), ('5', 'D', 'What is the function of a Browser ?', 'To view XML files', 'To view Web Pages', '  To connect to the internet', 'All of the above', 'CS1002'), ('6', 'C', 'All of the above', 'Outdated Electronic Machine', 'Original Electronic Market', 'Original Equipment Manufacturer', 'Output Enhanced Memory', 'CS1002'), ('7', 'C', 'How can you determine the size of a Hard Disk ?', 'How can you determine the size of a Hard Disk ?', 'By removing the Disk Dirve and seeing the label', 'By seeing the properties of the Drive', 'By clicking on My Documents', 'CS1002'), ('8', 'A', 'Dot Matrix printers are', 'Impact Printers', 'Thermal Printers', 'Non-Impact Printers', 'All of the Above', 'CS1002'), ('10', 'A', 'What is DOS', 'Disk Operating System', 'Data Operating System', 'Disk Of Storage', 'Data Of Storage', 'CS1002'), ('11', 'C', 'Altavista is ', 'A IT company', 'A CBS product', 'A search engine', 'A Computer Magazine', 'CS1002'), ('12', 'D', 'What is the full form of DVD', 'Digital Versitile Disk', 'Digital Video Drive', 'Digital Velocity Drive', 'Digital Video Disk', 'CS1002');
COMMIT;

-- ----------------------------
--  Table structure for `bptzz_role`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_role`;
CREATE TABLE `bptzz_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK_eruqgn3tikytqc4e6fiu5h36j` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bptzz_student`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_student`;
CREATE TABLE `bptzz_student` (
  `student_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `firstname` varchar(255) NOT NULL,
  `gender` bit(1) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) NOT NULL,
  `overallgpa` float NOT NULL,
  `profilepic` varchar(255) DEFAULT NULL,
  `year_enrolled` int(11) NOT NULL,
  `student_department` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FKj4a26gb1qmgd4oxjengvr19ju` (`student_department`),
  CONSTRAINT `FKj4a26gb1qmgd4oxjengvr19ju` FOREIGN KEY (`student_department`) REFERENCES `bptzz_department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bptzz_student`
-- ----------------------------
BEGIN;
INSERT INTO `bptzz_student` VALUES ('1', '493 Josephine Ave. Windsor, ON, CA', '1989-02-05 10:39:33', 'Tengxiaoyao (Tab)', b'1', 'www.ttxy.org', 'Tu', '3.5', '1511076503547.jpg', '2017', '1'), ('2', '720 Cambell Ave. Windsor, ON, CA', '1993-08-27 00:00:00', 'Yunpeng (Steven)', b'1', null, 'Bai', '3.4', '1511077982358.jpg', '2017', '1');
COMMIT;

-- ----------------------------
--  Table structure for `bptzz_student_course`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_student_course`;
CREATE TABLE `bptzz_student_course` (
  `student_id` bigint(20) NOT NULL,
  `course_id` varchar(255) NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `FK2k0jc2j37tcdd21kxtskbhtqn` (`course_id`),
  CONSTRAINT `FK21bvy760tqvudv27c3xehtboc` FOREIGN KEY (`student_id`) REFERENCES `bptzz_student` (`student_id`),
  CONSTRAINT `FK2k0jc2j37tcdd21kxtskbhtqn` FOREIGN KEY (`course_id`) REFERENCES `bptzz_course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bptzz_student_course`
-- ----------------------------
BEGIN;
INSERT INTO `bptzz_student_course` VALUES ('1', 'CS1001'), ('1', 'CS1002'), ('1', 'CS1003');
COMMIT;

-- ----------------------------
--  Table structure for `bptzz_user`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_user`;
CREATE TABLE `bptzz_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `introduction` text,
  `last_modify_time` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `validata_code` varchar(255) DEFAULT NULL,
  `user_student` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_i9q8lgwgkk4u5xowv2nge1ctr` (`email`),
  UNIQUE KEY `UK_d6uu3w1si11fh5xi00e68a7tm` (`username`),
  KEY `FK2equ07vd0cfppg6vcdi884q83` (`user_student`),
  CONSTRAINT `FK2equ07vd0cfppg6vcdi884q83` FOREIGN KEY (`user_student`) REFERENCES `bptzz_student` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `bptzz_user`
-- ----------------------------
BEGIN;
INSERT INTO `bptzz_user` VALUES ('3', '1510879247253', 'bai11e@uwindsor.ca', b'1', null, '1510879247253', '$2a$10$IRPVlyISQxWsyJMWAUjiCe8OW5RvUnAELcFmW6alxazSEAebwXTCS', null, 'steven', null, null), ('4', '1510879269960', 'pan14@uwindsor.ca', b'1', null, '1510879269960', '$2a$10$vxpkp.UU42ms.Uvo.ruKTuBQWvAdL17lUTHbUM3JqNRqAA4dFPGzC', null, 'eason', null, null), ('6', '1510879395282', 'zhou@uwindsor.ca', b'1', null, '1510879395282', '$2a$10$E9j1LWVSok3NIaQ0WCUDCONbPpvpULhyo1nWDM8H6QSWXG0Aj7eqK', null, 'cecilia', null, null), ('9', '1511057007713', 'tu6@uwindsor.ca', b'1', null, '1511057007713', '$2a$10$J7Vs.g70im.F1By73R8oGe7nh8uJbUGRbGR/d0qdH5s/iq6aEOCK6', null, 'tabtu', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `bptzz_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_user_role`;
CREATE TABLE `bptzz_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK31v5662pi72gafal6xm4vvp4r` (`role_id`),
  CONSTRAINT `FK31v5662pi72gafal6xm4vvp4r` FOREIGN KEY (`role_id`) REFERENCES `bptzz_role` (`role_id`),
  CONSTRAINT `FK5m61yr0wa6s22evy1ljsc0n32` FOREIGN KEY (`user_id`) REFERENCES `bptzz_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
