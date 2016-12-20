package model;

/**
 * Created by ZhangYF on 2016/12/9.
 */
public class Grade {
    private String studentID;
    private String courseName;
    private boolean isTest;
    private double exam;
    private double lab;
    private double grade;

    public Grade(String studentID, String courseName, double exam, double lab, double grade) {
        this.studentID = studentID;
        this.courseName = courseName;
        this.exam = exam;
        this.lab = lab;
        this.grade = grade;
        this.isTest = true;
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

    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }

    public double getLab() {
        return lab;
    }

    public void setLab(double lab) {
        this.lab = lab;
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }
}
