package edu.nju.j2ee.service.impl;

import edu.nju.j2ee.service.StudentManageService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Zhang YF on 2017/2/26.
 */
public class StudentManageServiceImplTest {
    @Test
    public void checkPassword() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        StudentManageService studentManageService = (StudentManageService) applicationContext.getBean("studentManageService");

        System.out.println(studentManageService.checkPassword("141250301","123456"));
    }

}