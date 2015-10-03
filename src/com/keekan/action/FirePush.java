package com.keekan.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.SessionManager;

public class FirePush extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		myUnicast();
		myMulticast();
		myBroadcast();
	}

	public void myUnicast() {
		if (SessionManager.getInstance().hasSession("10000")) {
			Event event = Event.createDataEvent("myevent1");
			event.setField("key1", "10000");
			Dispatcher.getInstance().unicast(event, "10000"); // 向ID为piero的用户推送
			System.out.println("success");
		} else {
			System.out.println("piero do not login");
		}
	}

	public void myMulticast() {
		if (SessionManager.getInstance().hasSession("20000")) {
			Event event = Event.createDataEvent("myevent1");
			event.setField("key1", "20000");
			Dispatcher.getInstance().unicast(event, "20000"); // 向ID为piero的用户推送
			System.out.println("success");
		} else {
			System.out.println("piero do not login");
		}
	}

	public void myBroadcast() {
		Event event = Event.createDataEvent("myevent1"); // 向所有的事件推送，不要求和这儿的myevent1名称匹配
		event.setField("key1", "index1--index2");
		Dispatcher.getInstance().broadcast(event);
		System.out.println("asw success");
	}
}
