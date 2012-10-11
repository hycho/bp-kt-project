package kr.co.kakaotheme.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import kr.co.kakaotheme.domain.User;
import kr.co.kakaotheme.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest{
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController controller = new UserController();
	
	private Model model;
	
	@Before
	public void setup(){
		ReflectionTestUtils.setField(controller, "userService", userService);
		model = new ExtendedModelMap();
	}
	
	@Test
	public void test_GetUser(){
		User user = new User("hycho","hycho","hycho","hycho");
		when(userService.getUserInfo("hycho", "hycho")).thenReturn(user);
		
		assertThat(controller.getLogin("hycho", "hycho", model), is("sample/sample"));
	}
}
