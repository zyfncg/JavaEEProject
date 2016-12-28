package factory;

import service.GradeManageService;
import service.impl.GradeManageServiceImpl;

/**
 * Created by ZhangYF on 2016/12/25.
 */
public class ServiceFactory {
    public static GradeManageService getGradeManageService(){
        return GradeManageServiceImpl.getInstance();
    }
}
