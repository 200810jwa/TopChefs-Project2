package UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.templates.LoginTemplate;

public class UserServiceTests {

	private UserService us;
	private User u;
	private LoginTemplate template;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		UserService us = new UserService();
		LoginTemplate template = new LoginTemplate("username","password");
		User u = new User();
	}

	/*
	 * Will be invoked after each individual test case
	 * Used to clean up the specific test environment
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginSuccessful() {
		assertEquals(us.login(template),u);	
	}
	
	@Test
	public void testLoginFailure() {
		
	}
	
	
	
}
