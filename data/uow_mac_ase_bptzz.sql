/*
 Navicat Premium Data Transfer

 Source Server         : osx
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : uow_mac_ase_bptzz

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 10/02/2017 23:24:33 PM
*/

/**
 * Create the database schema
 *
 * @author 	Eason Pan
 * @date	2017-10-10
 * @since	1.0
 */


# SET NAMES utf8mb4;

-- ----------------------------
--  Create database `pro611db`
-- ----------------------------

# DROP DATABASE IF EXISTS pro611db;
# CREATE DATABASE pro611db;
# USE pro611db;



-- ----------------------------
--  Table structure for `bptzz_Department`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_Department`;
CREATE TABLE `bptzz_Department` (
  `DeptID` varchar(8) NOT NULL,
  `DeptName` varchar(50) NOT NULL,
  PRIMARY KEY (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
--  Table structure for `bptzz_Student`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_Student`;
CREATE TABLE `bptzz_Student` (
  `StudentID` varchar(20) NOT NULL ,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `ProfilePic` blob,
  `Gender` varchar(1) NOT NULL ,
  `DOB` date NOT NULL ,
  `Address` varchar(255) NOT NULL ,
  `Homepage` varchar(255) DEFAULT NULL,
  `YearEnrolled` int(11) NOT NULL,
  `OverallGPA` float(3,2),
  `DeptID` varchar(8) NOT NULL,
  PRIMARY KEY (`StudentID`),
  KEY `FK_in_bptzz_Student` (`DeptID`),
  CONSTRAINT `FK_in_bptzz_Student` FOREIGN KEY (`DeptID`) REFERENCES
    `bptzz_Department` (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
--  Table structure for `User`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_User`;
CREATE TABLE `bptzz_User` (
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Type` varchar(1) NOT NULL,
  `StudentID` varchar(20) NOT NULL ,
  PRIMARY KEY (`UserName`),
  KEY `FK_in_bptzz_User` (`StudentID`),
  CONSTRAINT `FK_in_bptzz_User` FOREIGN KEY (`StudentID`) REFERENCES
    `bptzz_Student` (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- ----------------------------
--  Table structure for `bptzz_Instructor`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_Instructor`;
CREATE TABLE `bptzz_Instructor` (
  `InstructorID` varchar(10) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `ProfilePic` blob,
  `Gender` varchar(1) NOT NULL ,
  `DOB` date NOT NULL ,
  `Address` varchar(255) NOT NULL ,
  `Homepage` varchar(255) DEFAULT NULL,
  `YearEnrolled` int(11) NOT NULL,
  PRIMARY KEY (`InstructorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `bptzz_Course`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_Course`;
CREATE TABLE `bptzz_Course` (
  `CourseID` varchar(10) NOT NULL ,
  `CourseName` varchar(50) NOT NULL,
  `Term` varchar(10) NOT NULL,
  `Credits` int(11) NOT NULL,
  `Textbook` varchar(50) DEFAULT NULL,
  `RefTextbook` varchar(255) DEFAULT NULL,
  `CourseLink` varchar(255) DEFAULT NULL ,
  `DeptID` varchar(8) NOT NULL,
  PRIMARY KEY (`CourseID`,`Term`),
  KEY `FK_in_bptzz_Course` (`DeptID`),
  CONSTRAINT `FK_in_bptzz_Course` FOREIGN KEY (`DeptID`) REFERENCES
    `bptzz_Department` (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `bptzz_CoursePrerequisite`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_CoursePrerequisite`;
CREATE TABLE `bptzz_CoursePrerequisite` (
  `PrereID` int(11) NOT NULL AUTO_INCREMENT,
  `CourseID` varchar(10) NOT NULL ,
  `PrereCourseID` varchar(20) NOT NULL ,
  PRIMARY KEY (`PrereID`),
  KEY `FK_in_bptzz_CoursePrerequisite1` (`CourseID`),
  CONSTRAINT `FK_in_bptzz_CoursePrerequisite1` FOREIGN KEY (`CourseID`) REFERENCES
    `bptzz_Course` (`CourseID`),
  KEY `FK_in_bptzz_CoursePrerequisite2` (`PrereCourseID`),
  CONSTRAINT `FK_in_bptzz_CoursePrerequisite2` FOREIGN KEY (`PrereCourseID`) REFERENCES
    `bptzz_Course` (`CourseID`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `bptzz_InstructorDept`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_InstructorDept`;
CREATE TABLE `bptzz_InstructorDept` (
  `InstructorID` varchar(10) NOT NULL,
  `DeptID` varchar(8) NOT NULL,
  PRIMARY KEY (`InstructorID`,`DeptID`),
  KEY `FK_in_bptzz_InstructorDept1` (`InstructorID`),
  CONSTRAINT `FK_in_bptzz_InstructorDept1` FOREIGN KEY (`InstructorID`) REFERENCES
    `bptzz_Instructor` (`InstructorID`),  
  KEY `FK_in_bptzz_InstructorDept2` (`DeptID`),
  CONSTRAINT `FK_in_bptzz_InstructorDept2` FOREIGN KEY (`DeptID`) REFERENCES
    `bptzz_Department` (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
--  Table structure for `bptzz_CourseReg`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_CourseReg`;
CREATE TABLE `bptzz_CourseReg` (
  `StudentID` varchar(20) NOT NULL ,
  `CourseID` varchar(10) NOT NULL ,
  `Term` varchar(10) NOT NULL,
  `Grade` varchar(2) DEFAULT NULL ,
  PRIMARY KEY (`StudentID`,`CourseID`, `Term`),
  KEY `FK_in_bptzz_CourseReg1` (`StudentID`),
  CONSTRAINT `FK_in_bptzz_CourseReg1` FOREIGN KEY (`StudentID`) REFERENCES
    `bptzz_Student` (`StudentID`),  
  KEY `FK_in_bptzz_CourseReg2` (`CourseID`, `Term`),
  CONSTRAINT `FK_in_bptzz_CourseReg2` FOREIGN KEY (`CourseID`, `Term`) REFERENCES
    `bptzz_Course` (`CourseID`, `Term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- ----------------------------
--  Table structure for `bptzz_InstructorCourses`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_InstructorCourses`;
CREATE TABLE `bptzz_InstructorCourses` (
  `InstructorID` varchar(10) NOT NULL,
  `CourseID` varchar(10) NOT NULL ,
  `Term` varchar(10) NOT NULL,
  PRIMARY KEY (`InstructorID`,`CourseID`,`Term`),
  KEY `FK_in_bptzz_InstructorCourses1` (`InstructorID`),
  CONSTRAINT `FK_in_bptzz_InstructorCourses1` FOREIGN KEY (`InstructorID`) REFERENCES
    `bptzz_Instructor` (`InstructorID`),  
  KEY `FK_in_bptzz_InstructorCourses2` (`CourseID`, `Term`),
  CONSTRAINT `FK_in_bptzz_InstructorCourses2` FOREIGN KEY (`CourseID`, `Term`) REFERENCES
    `bptzz_Course` (`CourseID`, `Term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `bptzz_Classroom`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_Classroom`;
CREATE TABLE `bptzz_Classroom` (
  `ClassroomID` varchar(10) NOT NULL,
  `Location` varchar(50) NOT NULL,
  `MaxCapacity` int(11) NOT NULL,
  `SeatsLeft` int(11) NOT NULL,
  PRIMARY KEY (`ClassroomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `bptzz_ClassroomCourse`
-- ----------------------------
DROP TABLE IF EXISTS `bptzz_ClassroomCourse`;
CREATE TABLE `bptzz_ClassroomCourse` (
  `ClassroomID` varchar(10) NOT NULL,
  `CourseID` varchar(10) NOT NULL ,
  `Term` varchar(10) NOT NULL,
  `Period` int(11) NOT NULL,  -- A day has 12 periods and a week has 5 days.
  `Day` varchar(50) NOT NULL,  
  PRIMARY KEY (`ClassroomID`,`CourseID`,`Term`),
  KEY `FK_in_bptzz_ClassroomCourse1` (`ClassroomID`),
  CONSTRAINT `FK_in_bptzz_ClassroomCourse1` FOREIGN KEY (`ClassroomID`) REFERENCES
    `bptzz_Classroom` (`ClassroomID`),  
  KEY `FK_in_bptzz_ClassroomCourse2` (`CourseID`, `Term`),
  CONSTRAINT `FK_in_bptzz_ClassroomCourse2` FOREIGN KEY (`CourseID`, `Term`) REFERENCES
    `bptzz_Course` (`CourseID`, `Term`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
