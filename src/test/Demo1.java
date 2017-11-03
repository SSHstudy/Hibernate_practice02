package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import pers.wyt.domain.Person;
import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class Demo1 {

	
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Person person = new Person();
		person.setPname("aa");
		session.save(person);
		tr.commit();
		session.close();
	}
	
	@Test
	public void run() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		User user = new User();
		user.setName("bb");
		session.save(user);
		tr.commit();
		session.close();
	}
}
