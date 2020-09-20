package com.revature.unitTests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.models.User;
import com.revature.repositories.IRecipeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.services.UserService;
import com.revature.templates.LoginTemplate;
import com.revature.templates.RegisterTemplate;

public class UserServiceTests {

	@Mock
	private IUserDAO AMockedDao;
	@Mock
	private IRecipeDAO RMockedDao;
	
	
	private UserService testInstance = new UserService(AMockedDao);
	private User Andrew;
	private LoginTemplate AndrewTemp;
	private LoginTemplate wrongTemp1;
	private LoginTemplate wrongTemp2;
	private RegisterTemplate andrewReg;
	private User Zach;
	private User Leron;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testInstance = new UserService(AMockedDao);
		
		
		Andrew = new User(1,"alukens", "password","Andrew", "Lukens","email@email.com");
		AndrewTemp = new LoginTemplate("alukens", "password");
		wrongTemp1 = new LoginTemplate("alukens","wrongpassword");
		wrongTemp2 = new LoginTemplate("andrew", "pasword");
		andrewReg = new RegisterTemplate("andrew","password", "Andrew", "Lukens","email@email.com");
		Zach = new User(0, "zquinn", "password1", "Zach", "Quinn", "email1@email.com");
		
		when(AMockedDao.findByUsername("alukens")).thenReturn(Andrew);
		when(AMockedDao.findByUsername("leron1")).thenReturn(null);
		when(AMockedDao.save(Zach)).thenReturn(true);
		when(AMockedDao.findById(1)).thenReturn(Andrew);
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoginSuccesful() {
		assertEquals(testInstance.login(AndrewTemp), Andrew);
	}

	@Test
	public void testLoginPasswordFailure() {
		assertEquals(testInstance.login(wrongTemp1), null);
	}
	@Test
	public void testLoginUserFailure() {
		assertEquals(testInstance.login(wrongTemp2), null);
	}
	@Test
	public void testRegisterSuccessful() {
		assertEquals(testInstance.save(andrewReg), Andrew);
	}
	
}