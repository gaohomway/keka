package com.keekan.serve;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public interface MessageBoardServe {
	
	/**
	 * 添加留言
	 * @param keeno 号码
	 * @param friendnum 好友的号码
	 * @param messageContent 留言信息
	 * @param messageDate 留言时间
	 * @throws Exception
	 */
	int addMessage(Integer keeno,Integer friendKeeno,String messageContent,Date messageDate ) throws Exception;
	
	/**
	 * 查看留言
	 * @param keeno
	 * @return 
	 * @throws Exception
	 */
	List viewLeaveMessage(Integer keeno) throws Exception;
}
