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
 *          Date: 2012-08-16 Class Name: 用户状态Push<br>
 */
public class StatusPush {

	/**
	 * 在线状态
	 */
	public void online(Integer[] keeNumbers, Integer keeNumber) {
		for (int i = 0; i < keeNumbers.length; i++) {
			String friendNumber = String.valueOf(keeNumbers[i]);
			if (SessionManager.getInstance().hasSession(friendNumber)) {
				Event event = Event.createDataEvent("loginTopics");
				event.setField("friendNumber", keeNumber + "shangxianla");
				Dispatcher.getInstance().unicast(event, friendNumber); // 向ID为friendNumber的用户推送
				System.out.println("success");
			} else {
				System.out.println("not Login");
			}
		}
	}

	/**
	 * 离开状态
	 */
	public void leave() {
		if (SessionManager.getInstance().hasSession("11603")) {
			Event event = Event.createDataEvent("loginTopics");
			event.setField("friendNumber", "11603");
			Dispatcher.getInstance().unicast(event, "11603"); // 向ID为piero的用户推送
			System.out.println("success");
		} else {
			System.out.println("not Login");
		}
	}

	/**
	 * 忙碌状态
	 */
	public void busy() {
		Event event = Event.createDataEvent("loginTopics"); // 向所有的事件推送，不要求和这儿的myevent1名称匹配
		event.setField("friendNumber", "10000 -- 20000");
		Dispatcher.getInstance().broadcast(event);
		System.out.println("asw success");
	}

	/**
	 * 勿打扰状态
	 */
	public void notDisturb() {

	}

	/**
	 * 隐身状态
	 */
	public void stealth() {

	}

	/**
	 * 离线状态
	 */
	public void offline() {

	}

	/**
	 * 添加状态
	 */
	public void addStatue() {

	}
}
