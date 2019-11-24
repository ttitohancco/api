package com.itedes.facturacion.dto.purchase;

import org.json.JSONObject;

public class PurchaseResponseDto {
	private Integer id;
	private String date;
	private String time;
	private Integer product;
	private String name;
	private String description;
	private Integer quantity; 

	public PurchaseResponseDto (
		Integer id,
		String date,
		String time,
		Integer product,
		String name,
		String description,
		Integer quantity
	) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.product = product;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public Integer getProduct() {
		return product;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getQuantity() {
		return quantity;
	}
}