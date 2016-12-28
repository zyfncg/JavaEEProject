package service.impl;

import factory.DaoFactory;
import service.GradeManageService;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/28.
 */
public class GradeManageServiceImpl implements GradeManageService{

    private GradeManageServiceImpl(){}

    private static GradeManageService gradeService = new GradeManageServiceImpl();
    public static GradeManageService getInstance(){
        return gradeService;
    }

    @Override
    public List getGrade(String studentid) {
        return DaoFactory.getGradeDao().getGradeList(studentid);
    }
}
