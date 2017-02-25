package dao.daoImpl;

import dao.daoService.GradeDao;
import factory.DaoFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhangYF on 2017/2/23.
 */
public class GradeDaoImplTest {
    @Test
    public void getGradeList() throws Exception {
        GradeDao gradeDao = DaoFactory.getGradeDao();
        System.out.println(gradeDao.getGradeList("141250301").size());
    }

}