package com.keekan.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.keekan.test.Encrypt;
import com.keekan.tool.BaseTools;
import com.keekan.tool.DateTime;
import com.keekan.tool.GetIP;

/**
 * @author KEEKAN.10000`
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 用户加入Action <br>
 */
public class SignupAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Integer userId;				//标识符
	private String nickname; 			//昵称
 	private String password;			//密码
 	private String confirmPassword;		//确认密码
 	private String email;				//电子邮件
 	private String sex;					//性别
 	private String year;				//年
 	private String month;				//月
 	private String day;					//日
 	private String birthday;			//生日
 	private String nation;				//所在国家
 	private String city;				//所在市镇
 	private String area;				//所在市区
 	private String signupIp;			//注册IP
 	private String signupDate;			//注册日期
	private String vercode; 			//验证码
	private String vercodeyn;			//验证对否
	
	/**
	 * 验证码验证
	 * @return
	 * @throws Exception
	 */
	public String vercode() throws Exception {
		String verchar = (String) BaseTools.getSessionAttribute("verchar");
		BaseTools.getSession().setAttribute("verchar", null);
		if (vercode.equalsIgnoreCase(verchar)) {
			vercodeyn = "yes";
		}else {
			vercodeyn = "no";
		}
		return SUCCESS;
	}
	
	/**
	 * 注册处理
	 * @return
	 * @throws Exception
	 */
	public String signup() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = BaseTools.getSession();
		
		password = Encrypt.MD5Encode(password);
		birthday = year +"-"+ month +"-"+ day;
		signupIp = GetIP.getIP(request);
		signupDate = DateTime.getDateTime();
		
		userId = signupServe.saveUser(nickname, sex, birthday, nation, city, area, email, signupIp, signupDate);
		keeno = KeenoPoolServe.findKeenoById(userId);
		signupServe.saveKeeno(userId, keeno);
		loginServe.saveKeeno(keeno, password);
		session.setAttribute("keeno", keeno);
		return SUCCESS;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	public String getVercodeyn() {
		return vercodeyn;
	}
	public void setVercodeyn(String vercodeyn) {
		this.vercodeyn = vercodeyn;
	}
}