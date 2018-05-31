package DAO;

import java.util.List;

import entitys.User;

public interface UserServiceInterface {

	public void persist(User entity);
	
	public void update(User entity) ;
	
	public User findByUsername(String username) ;
	
	public void delete(String username);
	
	public List<User> findAll() ;
	
	public void deleteAll() ;
}
