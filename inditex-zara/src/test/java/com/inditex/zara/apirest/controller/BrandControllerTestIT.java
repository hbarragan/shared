package com.inditex.zara.apirest.controller;

import com.inditex.zara.TestMain;
import com.inditex.zara.apimodel.model.UrlConstants;
import com.inditex.zara.engine.data.model.Prices;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { TestMain.class })
@Transactional
public class BrandControllerTestIT
{
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;


	@Before
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void getAllBrand() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get(UrlConstants.BRAND)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.success", Matchers.is(true)))
				.andExpect(jsonPath("$.response", Matchers.hasSize(1)));
	}

}
