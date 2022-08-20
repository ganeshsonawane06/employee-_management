package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Country;
import com.employee.entity.CountryResponse;
import com.employee.repository.CountryRepo;
import com.employee.utils.Utils;

@Service
public class CountryService {
	@Autowired
	private CountryRepo countryRepo;
	
	public CountryResponse addCountry(Country country) {
		CountryResponse response = new CountryResponse();
		try {
			Country saved_country = countryRepo.save(country);
			
			response.setCountry(saved_country);
			response.setMessage(Utils.CONST_SUCCESS);
			
			return response;
		} catch (Exception e) {
			response.setMessage("Please provide valid country details ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public CountryResponse getAllCountries() {
		CountryResponse response = new CountryResponse();
		List<Country> countryList = (List<Country>) countryRepo.findAll();
		response.setCountries(countryList);
		
		return response;
	}
	
	public CountryResponse deleteCountry(long countryId) {

		CountryResponse response = new CountryResponse();
		try {
			countryRepo.deleteById(countryId);
	
			response.setMessage("Country having ID "+countryId+" deleted successfully.");
			
			return response;
		} catch (Exception e) {
			response.setMessage("Invalid country ID ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public CountryResponse updateCountry(Country country) {
		CountryResponse response = new CountryResponse();
		try {
			if (country.getCountryId() == 0) {
				response.setMessage("Please provide country ID !");
			} else {
				Country saved_country = countryRepo.save(country);
				response.setCountry(saved_country);
				response.setMessage(Utils.CONST_SUCCESS);
			}
			
			return response;
		} catch (Exception e) {
			response.setMessage("Unable to update country details ! Error:: "+e.getMessage());
			return response;
		}
	}
	
	public CountryResponse getCountry(long countryId) {
		CountryResponse response = new CountryResponse();
		try {
			Country country = countryRepo.findById(countryId).get();
			response.setCountry(country);
			
			return response;
		} catch (Exception e) {
			response.setMessage("Invalid country ID ! Error:: "+e.getMessage());
			return response;
		}
	}
}
