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
 * 测试查询
 * @author asus
 *
 */
public class Demo4 {

	/**
	 * 按条件查询
	 */
	@Test
	public void run6() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//先获取criteria接口
		Criteria criteria = session.createCriteria(User.class);
		
		//添加条件
		//Criteria是Hibernate提供的条件查询的对象，想传入条件的使用的工具类类Restrictions
		//Restrictions提供静态方法，拼接查询条件
		criteria.add(Restrictions.gt("age", 15));
		//继续添加条件
		criteria.add(Restrictions.like("name", "%c%"));
		
		List<User> list = criteria.list();
		System.out.println(list);
		tr.commit();
		session.close();
	}
	
	/**
	 * criteria接口
	 */
	@Test
	public void run5() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//先获取criteria接口
		Criteria criteria = session.createCriteria(User.class);
		//没有添加条件，默认查所有
		List<User> list = criteria.list();
		System.out.println(list);
		tr.commit();
		session.close();
	}
	
	@Test
	public void run4() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//查询方式HQL from User where 属性 条件
		//SQL:select * from t_user where 字段 条件
		Query query = session.createQuery("from User where age > :aaa");
		
		//设置值
		//两个%只要包含c
		query.setInteger("aaa", 20);
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
	
	/**
	 * 模糊查询
	 */
	@Test
	public void run3() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//查询方式HQL from User where 属性 条件
		//SQL:select * from t_user where 字段 条件
		Query query = session.createQuery("from User where name like ?");
		//设置值
		//两个%只要包含c
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
		//查询方式HQL from User where 属性 条件
		//SQL:select * from t_user where 字段 条件
		Query query = session.createQuery("from User where age > ?");
		//设置值
		query.setInteger(0, 20);
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
	
	/**
	 * 测试query的查询接口
	 */
	
	@Test
	public void run1() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//查询方式
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		tr.commit();
		session.close();
	}
}
