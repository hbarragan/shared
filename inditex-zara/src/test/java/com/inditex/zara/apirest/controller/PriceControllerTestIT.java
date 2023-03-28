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
public class PriceControllerTestIT
{
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	Prices prices;


	@Before
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		prices = new Prices();
		prices.setId(1L);
	}

	@Test
	public void getAllPrices() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get(UrlConstants.PRICES)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.success", Matchers.is(true)))
				.andExpect(jsonPath("$.response", Matchers.hasSize(4)));
	}

	@Test
	public void getPricesCurrentPrice1() throws Exception {

		executeMockMvcGetCurrentPrice("2020-06-14T10:00:00",35.5);
		executeMockMvcGetCurrentPrice("2020-06-14T16:00:00",25.45);
		executeMockMvcGetCurrentPrice("2020-06-14T21:00:00",35.50);
		executeMockMvcGetCurrentPrice("2020-06-15T10:00:00",30.50);
		executeMockMvcGetCurrentPrice("2020-06-16T21:00:00",38.95);
	}

	void executeMockMvcGetCurrentPrice(String stringDate,Double price) throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get(UrlConstants.PRICES+UrlConstants.CURRENT_PRICES+"?currentDate="+stringDate+"&brandId=1&productId=35455")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.success", Matchers.is(true)))
				.andExpect(jsonPath("$.response.price", Matchers.is(price)));
	}

}
