package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by ZhangYF on 2016/12/17.
 */
public class LoginSessionListener implements HttpSessionListener,HttpSessionAttributeListener{

    private static long onlineCounter = 0;
    private static long loginCounter = 0l;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        addOnlineNum();
        System.out.println("online number : "+ getOnlineCounter());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        subOnlineNum();
        System.out.println("online number : "+ getOnlineCounter());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        addLoginNum();
        System.out.println("login number : "+ getLoginCounter());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        subLoginNum();
        System.out.println("login number : "+ getLoginCounter());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

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

    private synchronized void addLoginNum(){
        loginCounter++;
    }
    private synchronized void subLoginNum(){
        loginCounter--;
    }
    public static long getLoginCounter() {
        return loginCounter;
    }
}
