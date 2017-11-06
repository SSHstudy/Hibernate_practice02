package pers.wyt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

/**
 * ���Բ�ѯ
 * @author asus
 *
 */
public class Demo4 {

	/**
	 * ��������ѯ
	 */
	@Test
	public void run6() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//�Ȼ�ȡcriteria�ӿ�
		Criteria criteria = session.createCriteria(User.class);
		
		//�������
		//Criteria��Hibernate�ṩ��������ѯ�Ķ����봫��������ʹ�õĹ�������Restrictions
		//Restrictions�ṩ��̬������ƴ�Ӳ�ѯ����
		criteria.add(Restrictions.gt("age", 15));
		//�����������
		criteria.add(Restrictions.like("name", "%c%"));
		
		List<User> list = criteria.list();
		System.out.println(list);
		tr.commit();
		session.close();
	}
	
	/**
	 * criteria�ӿ�
	 */
	@Test
	public void run5() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//�Ȼ�ȡcriteria�ӿ�
		Criteria criteria = session.createCriteria(User.class);
		//û�����������Ĭ�ϲ�����
		List<User> list = criteria.list();
		System.out.println(list);
		tr.commit();
		session.close();
	}
	
	@Test
	public void run4() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//��ѯ��ʽHQL from User where ���� ����
		//SQL:select * from t_user where �ֶ� ����
		Query query = session.createQuery("from User where age > :aaa");
		
		//����ֵ
		//����%ֻҪ����c
		query.setInteger("aaa", 20);
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
	
	/**
	 * ģ����ѯ
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//��ѯ��ʽHQL from User where ���� ����
		//SQL:select * from t_user where �ֶ� ����
		Query query = session.createQuery("from User where name like ?");
		//����ֵ
		//����%ֻҪ����c
		query.setString(0, "%c%");
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
	
	@Test
	public void run2() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//��ѯ��ʽHQL from User where ���� ����
		//SQL:select * from t_user where �ֶ� ����
		Query query = session.createQuery("from User where age > ?");
		//����ֵ
		query.setInteger(0, 20);
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
	
	/**
	 * ����query�Ĳ�ѯ�ӿ�
	 */
	
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//��ѯ��ʽ
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
}
