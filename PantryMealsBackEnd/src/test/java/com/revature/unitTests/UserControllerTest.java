package com.revature.unitTests;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.gen5.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.models.User;
import com.revature.services.UserService;

@ExtendWith(SpringExtension.class)
@Tag("Controller")
public class UserControllerTest {
	private MockMvc  mockMvc;
	
	@MockBean
	private UserService userService;
		List<User> userList;
		
		@BeforeEach
		public void setUp() {
			this.userList = new ArrayList<>();
			this.userList.add(new User(1, "alukens", "password", "Andrew",
							"Lukens", "alukens@gmail.com"));
			this.userList.add(new User(2, "zquinn", "password",
					"Zach", "Quinn", "zquinn@email.com"));
		}
		
		@Test
		public void  testCreateInvalidUser() throws Exception {
			this.mockMvc.perform(get("/")).andExpect(status().isOk());
		}
		
		@Test
		public void  fetchAllUsers() throws Exception{
			when(userService.findAll()).thenReturn( (Set<User>) userList);
			
			this.mockMvc.perform(get("/users"))
								.andExpect(status().isOk())
								.andExpect(jsonPath("$.size()", is(userList.size())));
		}
	
	
}

