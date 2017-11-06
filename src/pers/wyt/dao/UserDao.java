package pers.wyt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class UserDao {

	public void save1(User u1) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(u1);
	}

	public void save2(User u2) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(u2);
	}
}
