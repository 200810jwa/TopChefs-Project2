package com.revature.unitTests;


import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

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

public class UserServiceTests {

	@Mock
	private IUserDAO AMockedDao;
	@Mock
	private IRecipeDAO RMockedDao;
	
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
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoginSuccesful() {
		assertEquals(1,1);
	}
}