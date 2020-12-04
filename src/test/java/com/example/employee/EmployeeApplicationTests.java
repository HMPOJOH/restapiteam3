package com.example.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper mapper;


	@Test
	public void testGetEmployeeById() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/employees/4"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Aronsson")));
		//added one comment
	}

	@Test
	public void testPostEmployee() throws Exception {


		mvc.perform(
				MockMvcRequestBuilders.post("/employees")
						.content(mapper.writeValueAsString(new Employee(null, "Anna", "Andersson", "10", "HQ", 151515,null, "2020-12-18" )))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Anna")));


	}
}
