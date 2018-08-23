package com.jaytang.app;

import com.jaytang.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnowWebApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private TestService testService;

	@Autowired
	private MessagePublishService messagePublishService;

	@Autowired
	private MessageConsumerService messageConsumerService;


	@Test
	public void testRedisMsg(){
		messagePublishService.sendMessage(new String[]{"channel1"},"hello this is channel1") ;
		messageConsumerService.handleMessage(new String[]{"channel1"});
	}

	@Test
	public void getUser(){
		//TestService testService = new TestService();

		User user = testService.getUser("12");
		System.out.print(user.getName());
	}
}
