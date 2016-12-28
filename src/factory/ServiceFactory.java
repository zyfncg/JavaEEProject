package factory;

import service.GradeManageService;
import service.StudentManageService;
import service.impl.GradeManageServiceImpl;
import service.impl.StudentManageServiceImpl;

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
