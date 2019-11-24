package com.itedes.facturacion.dto.sales;

import org.json.JSONObject;

public class SalesResponseDto {
    private Integer id;
	private String date;
	private String time;
	private Integer product;
	private String name;
	private String description;
    private Integer quantity_sales;
    
    public SalesResponseDto (
        Integer id,
		String date,
		String time,
		Integer product,
		String name,
		String description,
		Integer quantity_sales
    )  {
		this.id = id;
		this.date = date;
		this.time = time;
		this.product = product;
		this.name = name;
		this.description = description;
        this.quantity_sales = quantity_sales;
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

	public Integer getQuantity_Sales() {
		return quantity_sales;
	}
}