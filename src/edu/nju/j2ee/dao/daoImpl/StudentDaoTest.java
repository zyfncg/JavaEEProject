package edu.nju.j2ee.dao.daoImpl;

import edu.nju.j2ee.dao.daoService.StudentDao;
import org.junit.Test;

/**
 * Created by ZhangYF on 2017/2/7.
 */
public class StudentDaoTest {

    private StudentDao studentDao;

    @Test
    public void checkPassword() throws Exception {
        System.out.println(studentDao.checkPassword("141250301","123456"));
    }

    @Test
    public void getStudent() throws Exception{
        System.out.println(studentDao.getStudent().size());
    }

}