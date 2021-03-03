package com.elasticsearch.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(indexName = "elasticsearch")
public class Car {

	@Id
	private String id;
	private String brand;
	private String color;
	private String type;

	private int price;
	private boolean available;
	@Field(type = FieldType.Date, format= DateFormat.date)
	@JsonFormat(pattern = "yyyy-MM-dd")
	
	private LocalDate firstReleaseDate;

	public Car(String brand, String color, String type, int price, boolean available, LocalDate firstReleaseDate) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
		this.price = price;
		this.available = available;
	
		this.firstReleaseDate = firstReleaseDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public LocalDate getFirstReleaseDate() {
		return firstReleaseDate;
	}

	public void setFirstReleaseDate(LocalDate firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}

	@Override
	public String toString() {
		return "id = "+  this.id +" Car [brand=" + brand + ", color=" + color + ", type=" + type + ", price=" + price + ", available="
				+ available + ", firstReleaseDate=" + firstReleaseDate + "]";
	}

}
