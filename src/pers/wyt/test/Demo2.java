package pers.wyt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.wyt.domain.Person;
import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class Demo2 {

	/**
	 * 持久态有自动更新数据库的能力
	 * session的一级缓存
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//获取持久态对象
		User user = session.get(User.class,2);
		System.out.println(user.getName());
		
		//重新设置新名称
		user.setName("cc");
		tr.commit();
		session.close();
	}
}
