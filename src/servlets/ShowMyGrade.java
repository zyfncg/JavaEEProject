package servlets;

import factory.ServiceFactory;
import model.GradeListBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ZhangYF on 2016/12/28.
 */
@WebServlet("/showmygrade")
public class ShowMyGrade extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public ShowMyGrade() {
        super();
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        HttpSession session = req.getSession(true);
        ServletContext context = getServletContext();
        GradeListBean gradeList = new GradeListBean();
        String studentid = (String)session.getAttribute("login");
        //listStock.setStockList(DaoFactory.getStockDao().find());
        gradeList.setGradeList(ServiceFactory.getGradeManageService().getGrade(studentid));
        try {
            if (gradeList.getGradeList().size() < 1) {
                System.out.println("eeeeeeeeeeeeeeeeeeee start");
                context.getRequestDispatcher("/IDError.jsp").forward(
                        req, resp);
                System.out.println("50 gradelist null");
            } else {
                System.out.println("ssssssssssssssssssssssssssssssssssss start");
                session.setAttribute("gradelist", gradeList);
                if(gradeList != null){
                    System.out.println(gradeList.getGrade(0).getCourseName());
                }
                context.getRequestDispatcher("/view/grade/myGrade.jsp").forward(
                        req, resp);
                System.out.println("55 grade id ok");
            }
        } catch (ServletException e) {
            // System error - report error 500 and message
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "This is a ServletException.");
        }
    }
}
