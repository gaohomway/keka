package com.keekan.pushlet;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.SessionManager;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16 Class Name: 聊天推Push<br>
 */
public class ChatPush {

	/**
	 * 在线状态
	 */
	public void sendChat(String keeno,String friendKeeno,String sendMessage) {
			if (SessionManager.getInstance().hasSession(friendKeeno)) {
				Event event = Event.createDataEvent("loginTopics");
				event.setField("keeno", keeno);
				event.setField("sendMessage", sendMessage);
				Dispatcher.getInstance().unicast(event, friendKeeno);
				System.out.println("success");
			} else {
				System.out.println("notLogin");
			}
	}
}
