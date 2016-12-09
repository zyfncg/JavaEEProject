DROP TABLE IF EXISTS student;
CREATE TABLE student (
	studentid char(9) PRIMARY KEY,
	name char(255) NOT NULL,
	password char(20) NOT NULL,
	gender char(8),
);
INTSERT INTO student(studentid,name,password,gender) VALUES ('141250301','doge','123456','男');


DROP TABLE IF EXISTS course;
CREATE TABLE course(
	courseid char(10) PRIMARY KEY,
	coursename char(56) NOT NULL,
);
INTSERT INTO course(courseid,coursename) VALUES ('1234567890','j2ee于中间件');
INTSERT INTO course(courseid,coursename) VALUES ('1234567891','软件工程');
INTSERT INTO course(courseid,coursename) VALUES ('1234567893','计算系统基础');


DROP TABLE IF EXISTS stud_cour;
CREATE TABLE student (
	studentid char(9) PRIMARY KEY,
	courseid char(10) PRIMARY KEY,
	grade double NOT NULL,
);
INTSERT INTO stud_cour(studentid,courseid,grade) VALUES ('141250301','1234567890',88);
INTSERT INTO stud_cour(studentid,courseid,grade) VALUES ('141250301','1234567891',76);