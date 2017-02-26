package edu.nju.j2ee.service.impl;

import edu.nju.j2ee.dao.daoService.StudentDao;
import edu.nju.j2ee.service.StudentManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zhang YF on 2016/12/28.
 */
@Service
public class StudentManageServiceImpl implements StudentManageService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean checkPassword(String studentid, String password) {
        return studentDao.checkPassword(studentid,password);
    }
}
