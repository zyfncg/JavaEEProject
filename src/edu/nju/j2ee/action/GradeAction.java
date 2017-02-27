package edu.nju.j2ee.action;

import edu.nju.j2ee.model.Grade;
import edu.nju.j2ee.model.GradeListBean;
import edu.nju.j2ee.service.GradeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/26.
 */
@Controller
public class GradeAction extends BaseAction{
    private static final long serialVersionUID = 1L;

    private GradeListBean gradeList;

    private List<Grade> list;
    private int listSize;

    @Autowired
    private GradeManageService gradeManageService;

    @Override
    public String execute() throws Exception {
        HttpSession httpSession = request.getSession(false);
        gradeList = new GradeListBean();
        if(null != httpSession){
            String studentid = (String)httpSession.getAttribute("login");
            if(null != studentid){
                gradeList.setGradeList(gradeManageService.getGrade(studentid));
                if(gradeList == null){
                    return "fail";
                }else{
                    System.out.print(gradeList.getGradeList().size()+" grade is not null");
                    httpSession.setAttribute("gradelist", gradeList);
                }

//                list = gradeManageService.getGrade(studentid);
//                listSize = list.size();

            }

//            session.put("gradelist",gradeList);
        }else{
            System.out.println("session is null");
        }

        System.out.println("ssssssssssssssssssssssssssssssssssss start");

        return "success";
    }


    public List<Grade> getList() {
        return list;
    }

    public void setList(List<Grade> list) {
        this.list = list;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
}
