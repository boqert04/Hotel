package DAO;

import java.util.List;

import DAO.UserDao;
import entitys.User;
public class UserService implements UserServiceInterface{

	private static UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	public void persist(User entity) {
		userDao.openCurrentSessionWithTransaction();
		userDao.persist(entity);
		userDao.closeCurrentSessionwithTransaction();
	}

	public void update(User entity) {
		userDao.openCurrentSessionWithTransaction();
		userDao.update(entity);
		userDao.closeCurrentSessionwithTransaction();
	}

	public User findByUsername(String username) {
		userDao.openCurrentSession();
		User User = userDao.findByUsername(username);
		userDao.closeCurrentSession();
		return User;
	}

	public void delete(String username) {
		userDao.openCurrentSessionWithTransaction();
		User User = userDao.findByUsername(username);
		userDao.delete(User);
		userDao.closeCurrentSessionwithTransaction();
	}

	public List<User> findAll() {
		userDao.openCurrentSession();
		List<User> Users = userDao.findAll();
		userDao.closeCurrentSession();
		return Users;
	}

	public void deleteAll() {
		userDao.openCurrentSessionWithTransaction();
		userDao.deleteAll();
		userDao.closeCurrentSessionwithTransaction();
	}

	public UserDao userDao() {
		return userDao;
	}
}
