package com.onesoft.car;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

@RestController
@RequestMapping(value="/car")
public class CarController {
	@Autowired
	CarService carSer;
	
	@Autowired
	RestTemplate rest;
	
	@GetMapping(value="/getEmployeeViaCar")
	public List<Employee> setemps() {
		String url="http://localhost:8080/employee/getvalue";
		
		ResponseEntity<List<Employee>>response=rest.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
		
		List<Employee> emps=response.getBody();
		return emps;
	}
	
	
	
	
	
	@PostMapping(value="/storeCarDetail")
	public String saveCar(@RequestBody Car c) {
		return carSer.saveCar(c);
	}
	@GetMapping(value="/getCarDetail/{id}")	
	public Car getCarDetail(@PathVariable int id) {
		return carSer.getCarDetail(id);
	}
	@PutMapping(value="/updateCarDetail/{c}")
	public String updateCarDetail(@RequestBody Car c) {
		return carSer.updateCarDetail(c);
	}
	@DeleteMapping(value="/deleteCarDetail")
	public String deleteCarDetail(@RequestBody Car c) {
		return carSer.deleteCarDetail(c);
	}
	
}
