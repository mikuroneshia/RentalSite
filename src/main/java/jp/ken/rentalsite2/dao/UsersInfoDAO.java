package jp.ken.rentalsite2.dao;

import java.util.List;

import jp.ken.rentalsite2.entity.UsersInfo;


public interface UsersInfoDAO<T> {
	public List<T> allList();
	
	public boolean insertUserData(UsersInfo user);
	
	public int updateUserData(UsersInfo user);
	
	public int deleteUserData(UsersInfo user);
}
