package edu.nju.j2ee.dao.daoImpl;

import edu.nju.j2ee.dao.daoService.GradeDao;
import edu.nju.j2ee.dao.hibernateSession.SessionConnect;
import edu.nju.j2ee.model.Grade;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/15.
 */
public class GradeDaoImpl implements GradeDao {

    private static GradeDaoImpl gradeDao = new GradeDaoImpl();
    private GradeDaoImpl() {

    }

    public static GradeDao getInstance(){
        return gradeDao;
    }
    @Override
    public List<Grade> getGradeList(String studentid) {

        Session session = SessionConnect.getSession();
        Transaction tx=session.beginTransaction();
        Query query = session.createQuery("SELECT g FROM Grade g WHERE g.student.studentid = :studentid");
        List<Grade> grades = query.setParameter("studentid",studentid).list();
//        List<Grade> grades = (List<Grade>) session.createQuery("FROM Grade g where g").list();

        session.close();
        return grades;
    }

}
