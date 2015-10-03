package com.keekan.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;

/**
 * @author yeeku.H.lee kongyeeku@163.com
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */@SuppressWarnings("unchecked")
public class JSONExample {
	
	private int[] ints = { 10, 20 };
	private Map map = new HashMap();
	private String customName = "custom";
	private String field1;
	private transient String field2;	// 'transient'不会被序列化
	private String field3;				// 没有setter和getter方法的字段不会被序列化

	
	public String execute() {
		map.put("name", "yeeku");
		return Action.SUCCESS;
	}

	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public int[] getInts() {
		return ints;
	}
	public void setInts(int[] ints) {
		this.ints = ints;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	@JSON(name = "newName")
	public String getCustomName() {
		return this.customName;
	}
}