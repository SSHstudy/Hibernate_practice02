package pers.wyt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class Demo3 {

	/**
	 * run1  run2��ʾ��ʧ���£�ͨ��debug
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//��ȡ�־�̬����
		User user = session.get(User.class,1);
		
		//��������������
		user.setName("change1");
		tr.commit();
		session.close();
	}
	
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//��ȡ�־�̬����
		User user = session.get(User.class,1);
		
		//��������������
		user.setAge(17);
		tr.commit();
		session.close();
	}
}
