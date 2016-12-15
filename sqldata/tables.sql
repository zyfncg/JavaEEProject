DROP TABLE IF EXISTS student;
CREATE TABLE student (
  studentid char(9) PRIMARY KEY,
  name char(255) NOT NULL,
  password char(20) NOT NULL,
  gender char(8)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO student(studentid,name,password,gender) VALUES ('141250301','doge','123456','男');


DROP TABLE IF EXISTS course;
CREATE TABLE course(
  courseid char(10) PRIMARY KEY,
  coursename char(56) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO course(courseid,coursename) VALUES ('1234567890','j2ee于中间件');
INSERT INTO course(courseid,coursename) VALUES ('1234567891','软件工程');
INSERT INTO course(courseid,coursename) VALUES ('1234567892','嵌入式');
INSERT INTO course(courseid,coursename) VALUES ('1234567893','计算系统基础');


DROP TABLE IF EXISTS stud_cour;
CREATE TABLE stud_cour (
  studentid char(9),
  courseid char(10),
  grade double,
  primary key (studentid,courseid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO stud_cour(studentid,courseid,grade) VALUES ('141250301','1234567890',88);
INSERT INTO stud_cour(studentid,courseid,grade) VALUES ('141250301','1234567891',76);
INSERT INTO stud_cour(studentid,courseid) VALUES ('141250301','1234567892');

DROP VIEW IF EXISTS gradeView;
CREATE ALGORITHM = UNDEFINED
VIEW gradeView AS
  SELECT student.studentid,student.name,coursename,grade FROM student,course,stud_cour
  WHERE student.studentid=stud_cour.studentid AND course.courseid=stud_cour.courseid;
