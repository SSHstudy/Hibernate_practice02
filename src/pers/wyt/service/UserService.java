package pers.wyt.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pers.wyt.dao.UserDao;
import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class UserService {

	public void save(User u1, User u2) {
		UserDao dao = new UserDao();
		//获取session
		Session session = HibernateUtils.getCurrentSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		
		try {

			dao.save1(u1);
			//int a = 10/0;
			dao.save2(u2);
			
			//提交事务
			tr.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			//出现问题，回滚事务
			tr.rollback();
		}finally {
			//释放资源，现在session不用手动关闭，线程结束自动关闭
		}
	}
}
