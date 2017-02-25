package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZhangYF on 2017/2/22.
 */
@Entity
@Table(name = "stud_cour", schema = "j2ee")
public class Grade implements Serializable{
//    private String studentid;
//    private String courseid;

    private StudCourPK id;

    private Double exam;
    private Double lab;
    private Double grade;
    private Student student;
    private Course course;

    @EmbeddedId
    public StudCourPK getId() {
        return id;
    }

    public void setId(StudCourPK id) {
        this.id = id;
    }

//    @Id
//    @Column(name = "studentid", nullable = false, length = 9)
//    public String getStudentid() {
//        return studentid;
//    }
//
//    public void setStudentid(String studentid) {
//        this.studentid = studentid;
//    }
//
//    @Id
//    @Column(name = "courseid", nullable = false, length = 10)
//    public String getCourseid() {
//        return courseid;
//    }
//
//    public void setCourseid(String courseid) {
//        this.courseid = courseid;
//    }

    @Basic
    @Column(name = "exam", nullable = true, precision = 0)
    public Double getExam() {
        return exam;
    }

    public void setExam(Double exam) {
        this.exam = exam;
    }

    @Basic
    @Column(name = "lab", nullable = true, precision = 0)
    public Double getLab() {
        return lab;
    }

    public void setLab(Double lab) {
        this.lab = lab;
    }

    @Basic
    @Column(name = "grade", nullable = true, precision = 0)
    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "studentid", insertable=false, updatable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "courseid", insertable=false, updatable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}
