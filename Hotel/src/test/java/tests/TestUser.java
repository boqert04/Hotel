package tests;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import DAO.UserService;
import entitys.User;



@ContextConfiguration(locations = { "classpath:/context.xml" })
//@ContextConfiguration(locations = { "/WEB-INF/mvc-dispatcher-servlet.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
	@Autowired
	private UserService userService ;

	@Autowired
	private User user;
//	@Test
//	public void insert() {
//		
//		user.setUsername("raul");
//		user.setPassword("spring");
//		System.out.println("starting persist");
//		userService.persist(user);
//		System.out.println("ending  persist");
//		System.out.println("starting search");
//		System.out.println("user is " + userService.findByUsername(user.getUsername()).getUsername());
//		System.out.println("ending search");
//
//
//	}
	
	@Test(expected=org.hibernate.exception.ConstraintViolationException.class)
	public void insert_duplicate() {
		user.setUsername("raul");
		user.setPassword("spring");
		userService.persist(user);
	}
	
	@Test
	public void update_user() {
		user.setPassword("low");
		userService.update(user);
	}
	
	@Test
	public void get_user() {
		user= userService.findByUsername("raul");
		System.out.println(user.getUsername());
	}
}
