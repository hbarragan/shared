package com.formacion;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.main.allow-bean-definition-overriding=true" })
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class CommonServiceTest {

	public Pageable getPageable(String sortField, String sortOrder) {
		return sortOrder.equalsIgnoreCase("desc") ? PageRequest.of(0, 10, Sort.by(sortField).descending())
				: PageRequest.of(0, 10, Sort.by(sortField).ascending());
	}

}
