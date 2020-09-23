package com.revature.unitTests;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.gen5.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.models.User;
import com.revature.services.UserService;

public class UserControllerTest {

	@Autowired
	private MockMvc  mockMvc;
	
	@Mock
	private UserService userService;

		private Set<User> userList;
		
		@BeforeEach
		public void setUp() {
			this.userList = new HashSet<>();
			this.userList.add(new User(1, "alukens", "password", "Andrew",
							"Lukens", "alukens@gmail.com"));
			this.userList.add(new User(2, "zquinn", "password",
					"Zach", "Quinn", "zquinn@email.com"));
		}
		
		@Test
		public void  fetchAllUsers() throws Exception{
			when(userService.findAll()).thenReturn( userList);
			
			this.mockMvc.perform(get("/users"))
								.andExpect(status().isOk())
								.andExpect(jsonPath("$.size()", is(userList.size())));
		}
	
	
}

