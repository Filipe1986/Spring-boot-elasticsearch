package com.elasticsearch.service;

import java.util.List;

import com.elasticsearch.entity.Car;

public interface CarService {

	List<String> BRANDS = List.of("Toyota", "Honda", "Ford", "BMW", "Mitsubishi");
	List<String> COLORS = List.of("Red", "Black", "White", "Blue", "Silver");
	List<String> TYPES = List.of("Sedan", "SUV", "MPV", "Hatchback", "Conversible");
	
	Car generateCar();
}
