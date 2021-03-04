package com.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.entity.Car;

@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car, String>{
	
	public List<Car> findByBrandAndColor(String brand, String color);

}
