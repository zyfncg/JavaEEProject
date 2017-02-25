package edu.nju.j2ee.factory;

import edu.nju.j2ee.dao.daoImpl.GradeDaoImpl;
import edu.nju.j2ee.dao.daoImpl.StudentDaoImpl;
import edu.nju.j2ee.dao.daoService.GradeDao;
import edu.nju.j2ee.dao.daoService.StudentDao;

/**
 * Created by ZhangYF on 2016/12/25.
 */
public class DaoFactory {
    public static GradeDao getGradeDao(){
        return GradeDaoImpl.getInstance();
    }

    public static StudentDao getStudentDao(){
        return StudentDaoImpl.getInstance();
    }
}
