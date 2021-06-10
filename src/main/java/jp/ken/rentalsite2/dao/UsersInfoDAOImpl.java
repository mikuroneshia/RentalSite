package jp.ken.rentalsite2.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jp.ken.rentalsite2.entity.UsersInfo;

public class UsersInfoDAOImpl implements UsersInfoDAO<UsersInfo>{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UsersInfo> allList() {
		// TODO 自動生成されたメソッド・スタブ
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From UsersInfo");
		List<UsersInfo>usersList=query.list();
		session.close();
		return usersList;
	}

	@Override
	public boolean insertUserData(UsersInfo uInfo) {
		// TODO 自動生成されたメソッド・スタブ
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.saveOrUpdate(uInfo);
			tx.commit();
			return true;
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}finally {
			session.close();
		}
	}

	@Override
	public int updateUserData(UsersInfo uInfo) {
		// TODO 自動生成されたメソッド・スタブ
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.saveOrUpdate(uInfo);
			tx.commit();
			return 1;
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		}finally {
			session.close();
		}
	}

	@Override
	public int deleteUserData(UsersInfo user) {
		// TODO 自動生成されたメソッド・スタブ
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			Query query=session.createQuery("from UsersInfo where id=?");
			query.setParameter(0, user.getId());
			UsersInfo uInfo=(UsersInfo)query.uniqueResult();
			session.delete(uInfo);
			tx.commit();
			return 1;
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		}finally {
			session.close();
		}
	}
	
}
