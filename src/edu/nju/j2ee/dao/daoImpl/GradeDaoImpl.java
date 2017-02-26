package edu.nju.j2ee.dao.daoImpl;

import edu.nju.j2ee.dao.daoService.BaseDao;
import edu.nju.j2ee.dao.daoService.GradeDao;
import edu.nju.j2ee.model.Grade;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/15.
 */

@Repository
public class GradeDaoImpl implements GradeDao {

    @Autowired
    private BaseDao baseDao;


    @Override
    public List<Grade> getGradeList(String studentid) {

        Session session = baseDao.getSession();
        Query query = session.createQuery("SELECT g FROM Grade g WHERE g.student.studentid = :studentid");
        List<Grade> grades = query.setParameter("studentid",studentid).list();

        return grades;
    }

}
