package edu.nju.j2ee.dao.daoImpl;

import edu.nju.j2ee.dao.daoService.GradeDao;
import org.junit.Test;

/**
 * Created by ZhangYF on 2017/2/23.
 */
public class GradeDaoImplTest {
    @Test
    public void getGradeList() throws Exception {
        GradeDao gradeDao = new GradeDaoImpl();
        System.out.println(gradeDao.getGradeList("141250301").size());
    }

}