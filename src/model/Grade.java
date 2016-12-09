package model;

/**
 * Created by ZhangYF on 2016/12/9.
 */
public class Grade {
    private String studentID;
    private String courseName;
    private double grade;

    public Grade(String studentID, String courseName, double grade) {
        this.studentID = studentID;
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
