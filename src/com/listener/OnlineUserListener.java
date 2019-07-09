package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		ServletContext context = session.getServletContext();
		Object object = context.getAttribute("onlineUserNum");
		if (object == null) {
           context.setAttribute("onlineUserNum", 1);
        } else {
            int onlineUserNum = (Integer) object;
            context.setAttribute("onlineUserNum", onlineUserNum + 1);
        }
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		ServletContext context = session.getServletContext();
		Object object = context.getAttribute("onlineUserNum");
		int onlineUserNum = (Integer) object;
		context.setAttribute("onlineUserNum", onlineUserNum-1);
	}

}
