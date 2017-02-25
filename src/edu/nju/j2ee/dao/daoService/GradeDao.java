package edu.nju.j2ee.dao.daoService;

import edu.nju.j2ee.model.Grade;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/15.
 */
public interface GradeDao {

    public List<Grade> getGradeList(String studentid);
}
