package pers.wyt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.wyt.domain.Person;
import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class Demo2 {

	/**
	 * �־�̬���Զ��������ݿ������
	 * session��һ������
	 */
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//��ȡ�־�̬����
		User user = session.get(User.class,2);
		System.out.println(user.getName());
		
		//��������������
		user.setName("cc");
		tr.commit();
		session.close();
	}
}
