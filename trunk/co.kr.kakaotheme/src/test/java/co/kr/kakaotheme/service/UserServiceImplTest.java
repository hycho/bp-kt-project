package co.kr.kakaotheme.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import co.kr.kakaotheme.domain.User;
import co.kr.kakaotheme.repository.UserRepository;
import co.kr.kakaotheme.service.impl.UserServiceImpl;

//차후 Dao쪽 정리가 완료되면 Dao를 추가한 서비스 호출 테스트 방법을 정리 하겠습니다.
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
