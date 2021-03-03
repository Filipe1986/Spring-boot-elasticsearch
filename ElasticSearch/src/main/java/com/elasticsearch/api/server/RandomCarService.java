package com.elasticsearch.api.server;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.elasticsearch.entity.Car;
import com.elasticsearch.service.CarService;
import com.elasticsearch.util.RandomDateUtil;

import io.netty.util.internal.ThreadLocalRandom;

@Service
public class RandomCarService implements CarService {

	@Override
	public Car generateCar() {
		String brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0, BRANDS.size()));
		String color = COLORS.get(ThreadLocalRandom.current().nextInt(0, COLORS.size()));
		String type = TYPES.get(ThreadLocalRandom.current().nextInt(0, TYPES.size()));
		LocalDate releaseDate = RandomDateUtil.generateRandomLocalDate();
		boolean available = ThreadLocalRandom.current().nextBoolean();
		int price = ThreadLocalRandom.current().nextInt(5000, 12001);
		return new Car(brand, color, type, price, available ,releaseDate);
	}

}
