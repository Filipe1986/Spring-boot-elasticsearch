package com.elasticsearch.api.server;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.entity.Car;
import com.elasticsearch.repository.CarElasticRepository;
import com.elasticsearch.service.CarService;

@RestController
@RequestMapping("/api/car/v1")
public class CarApi {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarElasticRepository carElasticRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
	public Car random() {
		return carService.generateCar();
	}
	
	@PostMapping(value = "/echo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String echo(@RequestBody Car car) {
		logger.info("{}", car);
		return car.toString();
	}
	
	@GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public String count() {
		return "There are : " + carElasticRepository.count() + " cars";
	}
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveCar(@RequestBody Car car) {
		logger.info("{}", car);
		Car carResult = carElasticRepository.save(car);
		return "Saved car: " + carResult.toString();
	}
	
	@GetMapping(value = "/{id}")
	public String getCar(@PathVariable("id") String id) {
		Optional<Car> car = carElasticRepository.findById(id);
		if(car.isPresent()) {
			return "Car: " + car.get().toString();
		}
		return "Car not found";
	}
	
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateCar(@PathVariable("id") String id , @RequestBody Car car ) {
		logger.info("{}", car);
		car.setId(id);
		Car carResult = carElasticRepository.save(car);
		return "Updated car: " + carResult.toString();
	}
	
	@GetMapping(value = "/cars" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getCarByBrandAndColor(@RequestBody Car car ){
		List<Car> cars = carElasticRepository.findByBrandAndColor(car.getBrand(), car.getColor());
		
		return cars;
	}
	
	@GetMapping(value = "/cars/{brand}/{color}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getPathCarByBrandAndColor(
			@PathVariable("brand") String brand,
			@PathVariable("color") String color){
		List<Car> cars = carElasticRepository.findByBrandAndColor(brand, color);
		
		return cars;
	}
	
	@GetMapping(value = "/cars" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getParametersCarByBrandAndColor(
			@RequestParam("brand") String brand,
			@RequestParam("color") String color){
		List<Car> cars = carElasticRepository.findByBrandAndColor(brand, color);
		
		return cars;
	}
	
	
	
}
