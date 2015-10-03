package com.keekan.serve;

public interface LoginServe {
	
	 /**
     * 验证用户登陆
     * @param keeno
     * @param password
	 * @return
     */
    Integer login(Integer keeno, String password) throws Exception;
    
    /**
     * 保存号码
     * @param keeno
     * @param password
     * @return
     * @throws Exception
     */
    Integer saveKeeno(Integer keeno, String password) throws Exception;
}
