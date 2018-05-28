package tests;
import org.junit.*;

import DAO.UserService;
import local.User;

public class TestUser {
	UserService userService = new UserService();

	@Test
	public void insert() {
		User user1 = new User("luis", "hola");
		System.out.println("starting persist");
		userService.persist(user1);
		System.out.println("ending  persist");
		System.out.println("starting search");
		System.out.println("user is " + userService.findByUsername(user1.getUsername()).getUsername());
		System.out.println("ending search");


	}
}
