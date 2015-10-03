package com.keekan.serve;

import java.util.List;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 标签的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public interface TagServe {
	
	/**
	 * 标签
	 * @return
	 */
	List tag() throws Exception;

	/**
	 * 标签库
	 * @return
	 */
	List tags() throws Exception;

}
