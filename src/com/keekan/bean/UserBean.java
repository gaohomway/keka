package com.keekan.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: User Information Bean<br>
 */
public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 基本信息
	 */
 	private Integer userId;			//标识符
 	private Integer keeno;			//KEE号码
 	
 	private String nickname;		//昵称
 	private String name;			//真实姓名
 	private String englishName;		//英文名
 	
 	private String sex;				//性别
 	private String birthday;		//生日
 	private Integer age;			//年龄
 	
 	private String zodiac;			//生肖
 	private String constellation;	//星座
 	private String bloodType;		//血型
 	
 	private String feelin;			//情感状态
 	private String feelinProclaim;	//情感宣言
 	
 	private String smoke;			//抽烟情况
 	private String drink;			//喝酒情况
 	private String sleep;			//睡眠情况
 	
 	private String nation;			//所在国家
 	private String city;			//所在市镇
 	private String area;			//所在市区
 	
 	private String homeNation;		//故乡国家
 	private String homeCity;		//故乡市镇
 	private String homeArea;		//故乡市区
 	
 	private String explains;		//个人说明
 	
 	/**
 	 * 详细信息
 	 */
 	private String telephone;		//电话号码
 	private Integer mobileNumber;	//手机号码
 	
 	private String email;			//电子邮件
 	private String homepage;		//主页地址
 	
 	private String vocation;		//职业
 	private String education;		//学历
 	private String school;			//学校
 	private String language;		//语言

 	/**
 	 * 注册信息
 	 */
 	private String signupIp;		//注册IP
 	private String signupDate;		//注册日期
 	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getKeeno() {
		return keeno;
	}
	public void setKeeno(Integer keeno) {
		this.keeno = keeno;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getZodiac() {
		return zodiac;
	}
	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getFeelin() {
		return feelin;
	}
	public void setFeelin(String feelin) {
		this.feelin = feelin;
	}
	public String getFeelinProclaim() {
		return feelinProclaim;
	}
	public void setFeelinProclaim(String feelinProclaim) {
		this.feelinProclaim = feelinProclaim;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getSleep() {
		return sleep;
	}
	public void setSleep(String sleep) {
		this.sleep = sleep;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHomeNation() {
		return homeNation;
	}
	public void setHomeNation(String homeNation) {
		this.homeNation = homeNation;
	}
	public String getHomeCity() {
		return homeCity;
	}
	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}
	public String getHomeArea() {
		return homeArea;
	}
	public void setHomeArea(String homeArea) {
		this.homeArea = homeArea;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSignupIp() {
		return signupIp;
	}
	public void setSignupIp(String signupIp) {
		this.signupIp = signupIp;
	}
	public String getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}
}
