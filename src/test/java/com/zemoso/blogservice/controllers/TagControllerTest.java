package com.zemoso.blogservice.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.zemoso.blogservice.controller.TagController;
import com.zemoso.blogservice.model.Tag;
import com.zemoso.blogservice.service.TagService;
import com.zemoso.blogservice.utilities.JsonUtils;
@RunWith(SpringRunner.class)
@WebMvcTest(TagController.class)
public class TagControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	TagService tagService;
	
	@Test
	public void getAllTagsPass1() throws Exception {
		List<Tag> tagList = new ArrayList<>();
		Mockito.when(tagService.getAllTags()).thenReturn(tagList);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/tags").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andReturn();
	}
	
	@Test
	public void testTag() throws Exception {
		Tag mockTag= new Tag();
		mockTag.setTagId(1l);
		mockTag.setTagName("React");
		
		String inputAsJson = JsonUtils.mapToJson(mockTag);
		
		String URI = "/api/v1/tags";
		
		Mockito.when(tagService.createTag(Mockito.any(Tag.class))).thenReturn(mockTag);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputAsJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertEquals(outputInJson,inputAsJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
