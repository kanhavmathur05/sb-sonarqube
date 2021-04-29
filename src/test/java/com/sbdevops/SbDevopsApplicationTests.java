package com.sbdevops;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sbdevops.dao.UserRepository;
import com.sbdevops.model.User;
import com.sbdevops.service.UserService;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SbDevopsApplication.class)
class SbDevopsApplicationTests {

	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getUserTest() {
		when(repository.findAll()).thenReturn(Stream
							.of(new User(376,"Danile",31,"USA"),new User(958,"Huy",35,"UK")).collect(Collectors.toList()));

		assertEquals(2,service.getUsers().size());
	}
	
	@Test
	public void saveUserTest() {
		User user=new User(999,"Pranya",33,"Pune");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.addUser(user));
	}
	
	@Test
	public void deleteUserTest() {
		User user=new User(999,"Pranya",33,"Pune");
		service.deleteUser(user);
		verify(repository,times(1)).delete(user);
	}
	
	@Test
	void contextLoads() {
	}

}
	