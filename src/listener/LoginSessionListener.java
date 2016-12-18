package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by ZhangYF on 2016/12/17.
 */
public class LoginSessionListener implements HttpSessionListener{
    private static long loginCounter = 0l;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        addLoginNum();
        System.out.println("login number : "+ getLoginCounter());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        subLoginNum();
        System.out.println("login number : "+ getLoginCounter());
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
