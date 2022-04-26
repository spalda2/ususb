package com.spalda.usu_sb;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@WebMvcTest(controllers = EmployeesController.class)
@SpringBootTest
@AutoConfigureMockMvc
class UsuSbApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//@MockBean
    //private EmployeesSrv srvc;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void genDb() throws Exception {
		//Mockito.when(srvc.genTbl()).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/employees/gentbl").contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testEmployee() throws Exception {
		//List<Employee> l = srvc.getEmployees();
		//Mockito.when(l).thenReturn(l);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/employees").contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Milan"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(24));

	}

}
