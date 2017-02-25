package edu.nju.j2ee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/22.
 */
@Entity
@Table(name = "course", schema = "j2ee")
public class Course implements Serializable{
    private String courseid;
    private String coursename;
    private List<Student> students;

    @Id
    @Column(name = "courseid", length = 10)
    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    @Basic
    @Column(name = "coursename", nullable = false, length = 56)
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "stud_cour",
            joinColumns = @JoinColumn(name = "courseid"),
            inverseJoinColumns = @JoinColumn(name = "studentid")
    )
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course that = (Course) o;

        if (courseid != null ? !courseid.equals(that.courseid) : that.courseid != null) return false;
        if (coursename != null ? !coursename.equals(that.coursename) : that.coursename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseid != null ? courseid.hashCode() : 0;
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        return result;
    }
}
