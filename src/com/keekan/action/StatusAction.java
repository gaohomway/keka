package com.keekan.action;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.SessionManager;

/**
 * @author keekan.com keekan@keekan.com
 * @version 1.0 <br>
 *          Copyright (C), 2012-,KEEKAN <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Date: 2012-08-16
 *          Class Name: 用户状态Action<br>
 */
public class StatusAction {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 在线状态
	 */
	public void online(Integer[] keenos, Integer keeno){
		for (int i = 0; i < keenos.length; i++) {
			String friendKeeno = String.valueOf(keenos[i]);
            if (SessionManager.getInstance().hasSession(friendKeeno)) {
    			Event event = Event.createDataEvent("loginTopics");
    			event.setField("friendKeeno", keeno+"shangxianla");
    			Dispatcher.getInstance().unicast(event, friendKeeno); // 向ID为friendNumber的用户推送
    			System.out.println("success");
    		} else {
    			System.out.println("not Login");
    		}
		}
	}
	
	/**
	 * 离开状态
	 */
	public void leave(){
		if (SessionManager.getInstance().hasSession("11603")) {
			Event event = Event.createDataEvent("loginTopics");
			event.setField("friendKeeno", "11603");
			Dispatcher.getInstance().unicast(event, "11603"); // 向ID为piero的用户推送
			System.out.println("success");
		} else {
			System.out.println("not Login");
		}
	}
	
	
	/**
	 * 忙碌状态
	 */
	public void busy(){
		Event event = Event.createDataEvent("loginTopics"); // 向所有的事件推送，不要求和这儿的myevent1名称匹配
		event.setField("friendKeeno", "10000 -- 20000");
		Dispatcher.getInstance().broadcast(event);
		System.out.println("asw success");
	}
	
	/**
	 * 勿打扰状态
	 */
	public void notDisturb(){
		
	}
	
	/**
	 * 隐身状态
	 */
	public void stealth(){
		
	}
	
	
	/**
	 * 离线状态
	 */
	public void offline(){
		
	}
	
	/**
	 * 添加状态
	 */
	public void addStatue(){
		
	}
}
