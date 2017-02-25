package edu.nju.j2ee.service.impl;

import edu.nju.j2ee.factory.DaoFactory;
import edu.nju.j2ee.service.StudentManageService;

/**
 * Created by Zhang YF on 2016/12/28.
 */
public class StudentManageServiceImpl implements StudentManageService{
    private static StudentManageService studentManageService = new StudentManageServiceImpl();
    public static StudentManageService getInstance(){
        return studentManageService;
    }

    private StudentManageServiceImpl(){}

    @Override
    public boolean checkPassword(String studentid, String password) {
        return DaoFactory.getStudentDao().checkPassword(studentid,password);
    }
}
