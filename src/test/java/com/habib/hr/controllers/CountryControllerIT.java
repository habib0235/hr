package com.habib.hr.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

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
import com.habib.hr.dto.CountryDTO;
import com.habib.hr.dto.RegionDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = HrApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@Sql({ "/countries_schema.sql", "/regions_data.sql", "/countries_data.sql" })
public class CountryControllerIT {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getCountryTest() throws Exception {
		CountryDTO expectedCountry = new CountryDTO("AR", "Argentina", new RegionDTO(2L, "Americas"));

		MockHttpServletResponse response = this.mockMvc
				.perform(
						get("/countries/AR").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedCountry, mapper.readValue(response.getContentAsString(), CountryDTO.class));

	}

	@Test
	public void getCountriesListAll() throws Exception {
		MockHttpServletResponse response = this.mockMvc.perform(
				get("/countries/list").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		CountryDTO[] responseValue = mapper.readValue(response.getContentAsString(), CountryDTO[].class);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(25, responseValue.length);
	}

	@Test
	public void getCountriesListByRegionTest() throws Exception {
		MockHttpServletResponse response = this.mockMvc.perform(
				get("/countries/region/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		CountryDTO[] responseValue = mapper.readValue(response.getContentAsString(), CountryDTO[].class);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(8, responseValue.length);
	}

	@Test
	public void createCountryTest() throws Exception {

		CountryDTO country = new CountryDTO("NC", "New Country", new RegionDTO(2L, "Americas"));

		MockHttpServletResponse response = this.mockMvc
				.perform(post("/countries/create").content(mapper.writeValueAsString(country))
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		CountryDTO responseValue = mapper.readValue(response.getContentAsString(), CountryDTO.class);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(country.getId(), responseValue.getId());
		assertEquals(country.getName(), responseValue.getName());
		assertEquals(country.getRegion(), responseValue.getRegion());

	}


	@Test
	public void updateCountryTest() throws  Exception {
		CountryDTO country = new CountryDTO("AR", "Argentina2", new RegionDTO(2L, "Americas"));

		MockHttpServletResponse response = this.mockMvc
				.perform(put("/countries/update/AR").content(mapper.writeValueAsString(country))
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		CountryDTO responseValue = mapper.readValue(response.getContentAsString(), CountryDTO.class);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(country.getId(), responseValue.getId());
		assertEquals(country.getName(), responseValue.getName());
		assertEquals(country.getRegion(), responseValue.getRegion());
	}
//	
//	

//	@Test
//	public void saveRegionTest() throws Exception {
//		
//		RegionDTO region = new RegionDTO(null, "New world");
//		
//		MockHttpServletResponse response = this.mockMvc.perform(
//				post("/regions/save").content(mapper.writeValueAsString(region)).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
//				.andReturn().getResponse();
//		RegionDTO responseValue = mapper.readValue(response.getContentAsString(), RegionDTO.class);
//
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
//		assertEquals(region.getName(), responseValue.getName());
//
//	}
}
