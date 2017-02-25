package edu.nju.j2ee.factory;

import edu.nju.j2ee.service.GradeManageService;
import edu.nju.j2ee.service.StudentManageService;
import edu.nju.j2ee.service.impl.GradeManageServiceImpl;
import edu.nju.j2ee.service.impl.StudentManageServiceImpl;

/**
 * Created by ZhangYF on 2016/12/25.
 */
public class ServiceFactory {
    public static GradeManageService getGradeManageService(){
        return GradeManageServiceImpl.getInstance();
    }

    public static StudentManageService getStudentManageService(){
        return StudentManageServiceImpl.getInstance();
    }
}
