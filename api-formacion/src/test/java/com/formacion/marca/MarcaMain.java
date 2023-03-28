package com.formacion.marca;

import com.formacion.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(excludeFilters  = {@ComponentScan.Filter(
		type = FilterType.ASSIGNABLE_TYPE, classes = {})})
@EnableJpaRepositories("com.formacion.marca.repository")
@ComponentScan(basePackages = { "com.formacion" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = { Main.class })
})
public class MarcaMain
{
	public static void main(String... args)
	{
		SpringApplication.run(MarcaMain.class);
	}

}
