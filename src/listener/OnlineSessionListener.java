package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by ZhangYF on 2016/12/17.
 */
public class OnlineSessionListener implements HttpSessionListener{
    private static long onlineCounter = 0l;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        addOnlineNum();
        System.out.println("online number : "+getOnlineCounter());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        subOnlineNum();
        System.out.println("online number : "+getOnlineCounter());
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
