package com.inditex.zara;

import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("int")
@SpringBootApplication
@ComponentScan(basePackages = { "com.inditex.zara" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = { Main.class }) })
@EnableJpaRepositories("com.inditex.zara.engine.data.repository")

public class TestMain
{
	@Test
	public void contextLoads() {
	}
}
