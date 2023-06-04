package com.habib.hr.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.habib.hr.HrApplication;
import com.habib.hr.dto.RegionDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = HrApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@Sql({ "/regions_schema.sql", "/regions_data.sql" })
public class RegionControllerIT {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getRegionTest() throws Exception {
		RegionDTO expectedRegion = new RegionDTO(1L, "Europe");

		MockHttpServletResponse response = this.mockMvc
				.perform(
						get("/regions/" + 1).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedRegion, mapper.readValue(response.getContentAsString(), RegionDTO.class));

	}

	@Test
	public void getRegionListTest() throws Exception {
		MockHttpServletResponse response = this.mockMvc
				.perform(
						get("/regions/list").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		RegionDTO[] responseValue = mapper.readValue(response.getContentAsString(), RegionDTO[].class);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(4, responseValue.length);
	}

	@Test
	public void saveRegionTest() throws Exception {

		RegionDTO region = new RegionDTO(null, "New world");

		MockHttpServletResponse response = this.mockMvc
				.perform(post("/regions/save").content(mapper.writeValueAsString(region))
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		RegionDTO responseValue = mapper.readValue(response.getContentAsString(), RegionDTO.class);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(5, responseValue.getId());
		assertEquals(region.getName(), responseValue.getName());
	}
}
