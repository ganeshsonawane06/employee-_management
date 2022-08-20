package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Country;
import com.employee.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping(path = "/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private ObjectMapper mapper;

	@PostMapping("/addCountry")
	public String addCountry(@RequestBody(required = true) Country country) throws JsonProcessingException {

		return mapper.writeValueAsString(countryService.addCountry(country));
	}

	@GetMapping(path = "/getAllCountries")
	public String getAllCountries() throws JsonProcessingException {
		return mapper.writeValueAsString(countryService.getAllCountries());
	}

	@PostMapping(path = "/updateCountry")
	public String updateCountry(@RequestBody(required = true) Country country) throws JsonProcessingException {

		return mapper.writeValueAsString(countryService.updateCountry(country));
	}

	@GetMapping(path = "/getCountryById")
	public String getCountryById(@RequestParam(name = "countryId", required = true) long countryId)
			throws JsonProcessingException {

		return mapper.writeValueAsString(countryService.getCountry(countryId));
	}

	@GetMapping(path = "/deleteCountry")
	public String deleteCountry(@RequestParam(name = "countryId", required = true) long countryId)
			throws JsonProcessingException {

		return mapper.writeValueAsString(countryService.deleteCountry(countryId));
	}
}
