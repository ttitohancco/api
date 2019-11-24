package com.itedes.facturacion.dto.sales;

import org.json.JSONObject;

public class SalesRequestCreationDto {
    private Integer product;
    private Integer quantity_sales;

    public SalesRequestCreationDto(JSONObject sales) {
        product = sales.getInt("product");
        quantity_sales = sales.getInt("quantity_sales");
    }

    public Integer getProduct() {
        return product;
    }

    public Integer getQuantity_Sales() {
        return quantity_sales;
    }
}