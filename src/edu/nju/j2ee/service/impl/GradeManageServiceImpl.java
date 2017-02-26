package edu.nju.j2ee.service.impl;

import edu.nju.j2ee.dao.daoService.GradeDao;
import edu.nju.j2ee.service.GradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/28.
 */
@Service
public class GradeManageServiceImpl implements GradeManageService{

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List getGrade(String studentid) {
        return gradeDao.getGradeList(studentid);
    }
}
