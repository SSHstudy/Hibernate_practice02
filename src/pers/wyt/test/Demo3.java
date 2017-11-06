package pers.wyt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class Demo3 {

	/**
	 * run1  run2演示丢失更新，通过debug
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//获取持久态对象
		User user = session.get(User.class,1);
		
		//重新设置新名称
		user.setName("change1");
		tr.commit();
		session.close();
	}
	
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//获取持久态对象
		User user = session.get(User.class,1);
		
		//重新设置新名称
		user.setAge(17);
		tr.commit();
		session.close();
	}
}
