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
        GradeListBean gradelist = new GradeListBean();
        String studentid = (String)session.getAttribute("login");
        //listStock.setStockList(DaoFactory.getStockDao().find());
        gradelist.setGradeList(ServiceFactory.getGradeManageService().getGrade(studentid));
        try {
            if (gradelist.getGradeList().size() < 1) {
                context.getRequestDispatcher("/stock/noListStock.jsp").forward(
                        req, resp);
            } else {
                session.setAttribute("gradelist", gradelist);
                context.getRequestDispatcher("/stock/listStock.jsp").forward(
                        req, resp);
            }
        } catch (ServletException e) {
            // System error - report error 500 and message
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "This is a ServletException.");
        }
    }
}
