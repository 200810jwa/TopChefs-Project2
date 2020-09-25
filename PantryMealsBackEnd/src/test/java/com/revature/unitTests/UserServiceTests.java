package com.revature.unitTests;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

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
	
	public static Set<User> userList;
	public static Set<User> emptyUserList;
	
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
		
		 userList = new HashSet<>();

		
		Andrew = new User(1,"alukens", "password","Andrew", "Lukens","email@email.com");
		Zach = new User(2, "zquinn", "password1", "Zach", "Quinn", "email1@email.com");
		Leron = new User();
		AndrewTemp = new LoginTemplate("alukens", "password");
		wrongTemp1 = new LoginTemplate("alukens","wrongpassword");
		wrongTemp2 = new LoginTemplate("andrew", "pasword");
		andrewReg = new RegisterTemplate("andrew","password", "Andrew", "Lukens","email@email.com");
		Zach = new User(0, "zquinn", "password1", "Zach", "Quinn", "email1@email.com");
		
		userList.add(Andrew);
		userList.add(Zach);
	
	
	
		
		when(AMockedDao.findByUsername("alukens")).thenReturn(Andrew);
		when(AMockedDao.findByUsername("leron1")).thenReturn(null);
		when(AMockedDao.save(Zach)).thenReturn(true);
		when(AMockedDao.findById(1)).thenReturn(Andrew);
		when(AMockedDao.findById(2)).thenReturn(Zach);
		when(AMockedDao.findAll()).thenReturn(userList);
		when(AMockedDao.delete(Zach)).thenReturn(true);
		when(AMockedDao.update(Andrew)).thenReturn(true);
		when(AMockedDao.update(Leron)).thenReturn(false);

		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	

	@Test
	public void testLoginPasswordFailure() {
		assertEquals(testInstance.login(wrongTemp1), null);
	}
	@Test
	public void testLoginUserFailureWrongPassword() {
		assertEquals(testInstance.login(wrongTemp2), null);
	}
	
	@Test
	public void testLoginUserFailureWrongUserName() {
		assertEquals(testInstance.login(wrongTemp2), null);
	}
	@Test
	public void testRegisterSuccessful() {
		assertEquals(testInstance.save(andrewReg), false);
	}
	
	@Test 
	public void testFindByIDSuccsseful2() {
		assertEquals(testInstance.findById(2), Zach);
	}
	@Test
	public void testFindByIDSuccessful() {
		assertEquals(testInstance.findById(1), Andrew);
	}
	
	@Test
	public void testUpdateUserSuccessful() {
		assertEquals(testInstance.update(Andrew), true);
	}
	@Test
	public void testUpdateUserFailure() {
		assertEquals(testInstance.update(null), false);
	}
	@Test
	public void testUpdateNullUser() {
		assertEquals(testInstance.update(Leron), false);
	}
	
	@Test
	public void testFindAllusersSuccessful() {
		assertEquals(testInstance.findAll(), userList);
	}
	
	@Test
	public void testFindByDFaillure() {
		assertEquals(testInstance.findById(3000), null);
	}
	
	@Test
	public void testDeleteUserSuccessfully() {
		assertEquals(testInstance.delete(Zach), true);
	}
	
	@Test
	public void testDeleteUserAndUpdateList() {
		userList.remove(Zach);
		assertEquals(testInstance.findAll(), userList);
		
	}
	
	@Test
	public void testDeleteUserFailure() {
		assertEquals(testInstance.delete(null), false);
	}
	
}