package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/22.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{
    private String studentid;
    private String name;
    private String password;
    private String gender;
    private List<Course> courses;

    @Id
    @Column(name = "studentid", length = 9)
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 8)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @ManyToMany(mappedBy = "students")
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student that = (Student) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
