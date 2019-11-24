package com.itedes.facturacion.controller;

import com.itedes.facturacion.dto.sales.SalesRequestCreationDto;
import com.itedes.facturacion.dto.sales.SalesResponseDto;

import java.util.ArrayList;

public class SalesController extends Controller {
    public SalesResponseDto create (SalesRequestCreationDto salesDto) throws Exception {
        String queryString = "SELECT sales FROM sales (" 
        + salesDto.getProduct().toString() + ", "
        + salesDto.getQuantity_Sales().toString()
    + ")";

    initializeConnection();

    try {
        resultset = statement.executeQuery(queryString);

        Integer salesId = null;

        while(resultset.next())
            salesId = resultset.getInt("sales");
        
        queryString = "SELECT * FROM sales_identify_by_id(" + salesId.toString() + ");";

        resultset = statement.executeQuery(queryString);

        SalesResponseDto responseDto = null;

        while(resultset.next())
            responseDto = new SalesResponseDto (
					resultset.getInt("id"), 
					resultset.getString("date"), 
					resultset.getString("time"), 
					resultset.getInt("product"), 
					resultset.getString("name"), 
					resultset.getString("description"), 
					resultset.getInt("quantity_sales")
                );
                
                closeConnection();

                return responseDto;
    } catch(Exception e) {
            throw new Exception(e);
    }
    }


    public void destroy(Integer id) throws Exception {
		String queryString = "SELECT sales_destroy(" + id.toString() + ")";

		initializeConnection();

		try {	
			statement.executeQuery(queryString);

			closeConnection();
		} catch(Exception e) {
            throw new Exception(e);
		}
	}
    
    public ArrayList<SalesResponseDto> search_sales(
        String from,
        String to,
        String name
    ) throws Exception  {
        String queryString = "SELECT * FROM sales_search (";

        if(!from.equals("--"))
            queryString += "p_date_from := '" + from + "'";

        if(!to.equals("--")) {
            if(!from.equals("--"))
                queryString += ", ";

            queryString += "p_date_to := '" + to + "'";
        }

        if (!name.equals("%")) {
            if(!from.equals("--") || !to.equals("--"))
                queryString += ", ";

            queryString = "p_product_name := '" + name + "'";
        }

        queryString += ")";

        initializeConnection();

        try { 
            resultset = statement.executeQuery(queryString);

			ArrayList<SalesResponseDto> sales = new ArrayList<SalesResponseDto>();

			while(resultset.next()) { 
				SalesResponseDto salesResponse = new SalesResponseDto (
					resultset.getInt("id"), 
					resultset.getString("date"), 
					resultset.getString("time"), 
					resultset.getInt("product"), 
					resultset.getString("name"), 
					resultset.getString("description"), 
					resultset.getInt("quantity_sales")
				);

				sales.add(salesResponse);
        }
        closeConnection();

        return sales;
    } catch(Exception e) {
        throw new Exception(e);
    }


    }
}