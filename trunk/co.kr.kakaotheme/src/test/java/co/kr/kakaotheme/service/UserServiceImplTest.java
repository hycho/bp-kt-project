package co.kr.kakaotheme.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

//차후 Dao쪽 정리가 완료되면 Dao를 추가한 서비스 호출 테스트 방법을 정리 하겠습니다.
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	private UserService userService;
	
	@Before
	public void setup(){
	}
	
	@Test
	public void test_getUser(){
		
	}
}
