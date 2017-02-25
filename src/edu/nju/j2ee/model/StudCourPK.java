package edu.nju.j2ee.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by ZhangYF on 2017/2/23.
 */
@Embeddable
public class StudCourPK implements Serializable {
    private String studentid;
    private String courseid;


    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudCourPK that = (StudCourPK) o;

        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) return false;
        if (courseid != null ? !courseid.equals(that.courseid) : that.courseid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentid != null ? studentid.hashCode() : 0;
        result = 31 * result + (courseid != null ? courseid.hashCode() : 0);
        return result;
    }
}
