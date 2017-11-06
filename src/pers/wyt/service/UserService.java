package pers.wyt.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pers.wyt.dao.UserDao;
import pers.wyt.domain.User;
import pers.wyt.utils.HibernateUtils;

public class UserService {

	public void save(User u1, User u2) {
		UserDao dao = new UserDao();
		//��ȡsession
		Session session = HibernateUtils.getCurrentSession();
		//��������
		Transaction tr = session.beginTransaction();
		
		try {

			dao.save1(u1);
			//int a = 10/0;
			dao.save2(u2);
			
			//�ύ����
			tr.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			//�������⣬�ع�����
			tr.rollback();
		}finally {
			//�ͷ���Դ������session�����ֶ��رգ��߳̽����Զ��ر�
		}
	}
}
