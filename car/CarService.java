package com.onesoft.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	CarDAO carDAO;
	
	public String saveCar(Car c) {
		return carDAO.saveCar(c);
	}
	public Car getCarDetail(int id) {
		return carDAO.getCarDetail(id);
	}
	public String updateCarDetail(Car c) {
		return carDAO.updateCarDetail(c);
	}
	public String deleteCarDetail(Car c) {
		return carDAO.deleteCarDetail(c);
	}
}
