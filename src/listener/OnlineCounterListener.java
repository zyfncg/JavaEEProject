package listener;

import javax.servlet.*;

/**
 * Created by Zhang YF on 2016/12/18.
 */
public class OnlineCounterListener implements ServletContextListener, ServletContextAttributeListener {

    private static long onlineCounter = 0;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext= sce.getServletContext();
        servletContext.setAttribute("onlineCounter", "0");
        System.out.println("Application initialized");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

    }

    private synchronized void addOnlineNum(){
        onlineCounter++;
    }
    private synchronized void subOnlineNum(){
        onlineCounter--;
    }

    public static long getOnlineCounter() {
        return onlineCounter;
    }
}
