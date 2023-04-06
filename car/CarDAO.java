package com.onesoft.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAO {
	@Autowired
	CarRepository carRepo;
	
	public String saveCar(Car c) {
		carRepo.save(c);
		return "Car detail saved Successfully";
	}
	public Car getCarDetail(int id) {
		return carRepo.findById(id).get();
	}
	public String updateCarDetail(Car c) {
		carRepo.save(c);
		return "Car detail updated Successfully";
	}
	public String deleteCarDetail(Car c) {
		carRepo.delete(c);
		return "Car detail deleted Successfully";
	}
}
