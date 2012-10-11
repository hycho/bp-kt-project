package kr.co.kakaotheme.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.co.kakaotheme.domain.User;
import kr.co.kakaotheme.repository.UserRepository;
import kr.co.kakaotheme.service.impl.UserServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

//차후 Dao�??�리�??�료?�면 Dao�?추�????�비???�출 ?�스??방법???�리 ?�겠?�니??
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
		
	
	@Before
	public void setup(){
		ReflectionTestUtils.setField(userServiceImpl, "userRepository", userRepository);
	}
	
	@Test
	public void test_getUserInfo(){
		User user = new User("hycho","hycho","hycho","hycho");
		User user1 = new User("hycho","hycho","hycho","hycho");
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user1);
		
		when(userRepository.findAllUser()).thenReturn(userList);
		assertTrue(userServiceImpl.findAllUsers().size() == 2);
		verify(userRepository, times(1)).findAllUser();
	}
}
