/**
*
* @author  ThanhDuyen
* @version 1.0
* @since   2020-08-29 
*/

package com.thanhduyen.springmybatis.util;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * The Class MyBatisUtil.
 */
public class MyBatisUtil {
	
	/** The sql session factory. */
	private static SqlSessionFactory sqlSessionFactory;
	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("resources/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the sql session factory.
	 *
	 * @return the sql session factory
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
} 