package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Zhang YF on 2016/12/28.
 */
public class GradeListBean implements Serializable{
    private List<Grade> gradeList;

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public Grade getGrade(int index){
        return gradeList.get(index);
    }
}
