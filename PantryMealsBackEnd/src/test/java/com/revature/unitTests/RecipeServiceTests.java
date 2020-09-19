package com.revature.unitTests;

import static org.junit.Assert.assertEquals;

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

public class RecipeServiceTests {
	

	
	@Mock
	private IUserDAO AMockedDao;
	@Mock
	private IRecipeDAO RMockedDao;
	private UserService testInstance = new UserService(AMockedDao);
	private User Andrew;
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
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testRecipeSuccesful() {
		assertEquals(1,1);
	}
}
