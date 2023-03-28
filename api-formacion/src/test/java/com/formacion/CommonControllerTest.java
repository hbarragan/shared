package com.formacion;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.validation.constraints.NotNull;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.main.allow-bean-definition-overriding=true" })
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class CommonControllerTest {

	@Autowired
	protected ObjectMapper objectMapper;

	@Autowired
	protected MockMvc mockMvc;

	protected MvcResult executeSucces(@NotNull MockHttpServletRequestBuilder request, String object) throws Exception {
		return mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON_VALUE).content(object))
				.andExpect(jsonPath("$.success", Matchers.is(true))).andReturn();
	}

	protected MvcResult executeError(@NotNull MockHttpServletRequestBuilder request, String object, String message)
			throws Exception {
		return mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON_VALUE).content(object))
				.andExpect(jsonPath("$.success", Matchers.is(false)))
				.andExpect(jsonPath("$.message", Matchers.is(message))).andReturn();
	}

}
