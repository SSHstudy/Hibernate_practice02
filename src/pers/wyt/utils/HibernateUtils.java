package pers.wyt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 *Hibernate��ܵĹ�����
 * @author asus
 *
 */
public class HibernateUtils {

	//�������븳ֵ
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	//��д��̬����
	static {
		//����xml�����ļ�
		CONFIG = new Configuration().configure();
		//��������
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	/**
	 * �ӹ����л�ȡSession����
	 * @return
	 */
	public static Session getSession() {
		return FACTORY.openSession();
	}
	public static void main(String[] args) {
		//���û�ȡsession����
		getSession();
		//һ���У����Զ����ɣ������ݿ�Ҫ�Լ�����
	}
}
