package edu.nju.j2ee.dao.daoImpl;

import edu.nju.j2ee.dao.daoService.GradeDao;
import edu.nju.j2ee.factory.DaoFactory;
import org.junit.Test;

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