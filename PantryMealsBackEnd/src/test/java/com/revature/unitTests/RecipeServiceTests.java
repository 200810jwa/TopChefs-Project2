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

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.IRecipeDAO;
import com.revature.repositories.IUserDAO;
import com.revature.services.RecipeService;

public class RecipeServiceTests {
	

	
	@Mock
	private IUserDAO AMockedDao;
	@Mock
	private IRecipeDAO RMockedDao;
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe sameIdRecipe;
	private RecipeService testInstance = new RecipeService(RMockedDao);
	private User Andrew;
	private User Zach;
	private User Leron;
	
	
	private static Set<Recipe> recipeList;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		testInstance = new RecipeService(RMockedDao);
		
		recipeList = new HashSet<>();
		
		recipe1 = new Recipe(1, "OnionVegetable", "hreflink"," Onions, Pepper");
		recipe2 = new Recipe(0, "OnionVegetable", "hreflink"," Onions, Pepper");
		recipeList.add(recipe1);
		recipeList.add(recipe2);
		
		
		
		when(RMockedDao.findbyId(0)).thenReturn(recipe2);
		when(RMockedDao.findbyId(1)).thenReturn(recipe1);
		when(RMockedDao.save(recipe1)).thenReturn(true);
		when(RMockedDao.delete(recipe1)).thenReturn(true);
		when(RMockedDao.update(recipe1)).thenReturn(true);
		when(RMockedDao.findAll()).thenReturn(recipeList);
	}
	
	
	@After
	public void tearDown() throws Exception {
	}
	
	public void testAddRecipeSuccesful() {
		assertEquals(testInstance.save(recipe1), true);
	}
	
	@Test
	public void testFindByIdSuccessfulOne() {
		assertEquals(testInstance.findById(0), recipe2);
	}
	
	@Test
	public void testFindByIdSuccessful() {
		assertEquals(testInstance.findById(1), recipe1);
	}
	
	@Test
	public void testDeleteRecipeSuccessful() {
		assertEquals(testInstance.delete(recipe1), true);
	}
	
	@Test
	public void testUpdateRecipeSuccessful() {
		assertEquals(testInstance.update(recipe1), true);
	}
	
	@Test
	public void testFindAllRecipeSuccessful() {
		assertEquals(testInstance.findAll(), recipeList);
	}
	
}
