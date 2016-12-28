package factory;

import dao.daoImpl.GradeDaoImpl;
import dao.daoImpl.StudentDaoImpl;
import dao.daoService.GradeDao;
import dao.daoService.StudentDao;

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
