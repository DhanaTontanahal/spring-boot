package com.zemoso.blogservice.controllers;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//helps the continuous integration server to have random port when app is run for testing
//unit tests will not fail because the port is already in use
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//powerful enough to launch entire application
//looks for the file with SpringBootApplication annotation and launches the entire spring boot application context
//also launched the in memory database
public class BlogControllerIT {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads1() throws JSONException {
		//launches entire spring boot application
		String response = this.testRestTemplate.getForObject("/api/v1/blogs", String.class);
		JSONAssert.assertEquals("[{blogId:1},{blogId:2}]", response, false);
	}
	
	@Test
	public void contextLoads2() throws JSONException {
		//launches entire spring boot application
		String response = this.testRestTemplate.getForObject("/api/v1/blogs/2", String.class);
		JSONAssert.assertEquals("{blogId:2, postedBy:'dhanatontanahal'}", response, false);
	}

}
