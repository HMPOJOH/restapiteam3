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

import static org.hamcrest.CoreMatchers.not;
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
		mvc.perform(MockMvcRequestBuilders.get("/employees/3"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Johansson")));
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

	@Test
	public void testPutEmployee() throws Exception{
		//get Berit Göransson id 5

		mvc.perform(
				MockMvcRequestBuilders.get("/employees/5")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Goransson")));

		//Change Göransson --> Svensson
		mvc.perform(
				MockMvcRequestBuilders.put("/employees/5")
						.content(mapper.writeValueAsString(new Employee(5L, "Berit", "Svensson", "19800458","Customer Service",500000,false,"1965-01-01" )))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().is2xxSuccessful());
		//get Berit Svensson id 5
		mvc.perform(
				MockMvcRequestBuilders.get("/employees/5")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
		)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Svensson")));


	}

	@Test
	public void testDeleteEmployeeById() throws Exception {

		//get id 4 = Aronsson
		mvc.perform(MockMvcRequestBuilders.get("/employees/4"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("Aronsson")));

		//delete id 4 Aronsson
		mvc.perform(
				MockMvcRequestBuilders.delete("/employees/4")
		)
				.andExpect(status().isNoContent());


		//Check Aronsson not existing
		mvc.perform(
				MockMvcRequestBuilders.get("/employees")
		)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(not(containsString("Aronsson"))));


	}

	@Test
	public void testDeleteEmployeeByIdThatIsNotFound() throws Exception {


		mvc.perform(
				MockMvcRequestBuilders.delete("/employees/9")
		)
				.andExpect(status().isNotFound());

	}


}
