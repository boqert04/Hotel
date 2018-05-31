package tests;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import DAO.UserService;
import entitys.User;

@ContextConfiguration(locations = { "classpath:/context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
	@Autowired
	private UserService userService ;

	@Autowired
	private User user;
	@Test
	public void insert() {
		
		user.setUsername("raul");
		user.setPassword("spring");
		System.out.println("starting persist");
		userService.persist(user);
		System.out.println("ending  persist");
		System.out.println("starting search");
		System.out.println("user is " + userService.findByUsername(user.getUsername()).getUsername());
		System.out.println("ending search");


	}
}
