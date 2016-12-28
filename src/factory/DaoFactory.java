package factory;

import dao.daoImpl.GradeDaoImpl;
import dao.daoService.GradeDao;

/**
 * Created by ZhangYF on 2016/12/25.
 */
public class DaoFactory {
    public GradeDao getGradeDao(){
        return GradeDaoImpl.getInstance();
    }
}
