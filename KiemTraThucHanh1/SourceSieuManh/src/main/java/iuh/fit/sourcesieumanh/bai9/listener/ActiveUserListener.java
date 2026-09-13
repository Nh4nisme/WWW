package iuh.fit.sourcesieumanh.bai9.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveUserListener implements ServletContextListener, HttpSessionListener {
    private static final String ATTR = "activeUsersCount";
    private static final AtomicInteger activeSessions = new AtomicInteger(0);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(ATTR, activeSessions);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute(ATTR);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        AtomicInteger counter = (AtomicInteger)
                se.getSession().getServletContext().getAttribute(ATTR);
        if (counter != null) counter.incrementAndGet();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        AtomicInteger counter = (AtomicInteger)
                se.getSession().getServletContext().getAttribute(ATTR);
        if (counter != null && counter.get() > 0) counter.decrementAndGet();
    }
}
