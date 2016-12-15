package data.dataService;

import model.Grade;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/15.
 */
public interface GradeDataService {

    public List<Grade> getGradeList(String studentid);
}
