package com.generator.csv.ms.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.generator.csv.ms.model.Orders;

public class CSVOrdersHelper {
	public static final String FILENAME = "order_export.csv";
	public static ByteArrayInputStream ordersToCsv(List<Orders> orders) {
		final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		
		try(ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);){
			for(Orders order : orders) {
				List<String> data = Arrays.asList(
						String.valueOf(order.getOrderId()),
						String.valueOf(order.getRegion()),
						String.valueOf(order.getCountry()),
						String.valueOf(order.getItemType()),
						String.valueOf(order.getSalesChannel()),
						String.valueOf(order.getOrderPriority()),
						dateFormat.format(order.getOrderDate()),
						dateFormat.format(order.getShipDate()),
						String.valueOf(order.getUnitsSold()),
						String.valueOf(order.getUnitPrice()),
						String.valueOf(order.getUnitCost()),
						String.valueOf(order.getTotalRevenue()),
						String.valueOf(order.getTotalCost()),
						String.valueOf(order.getTotalProfit())
						);
				
				csvPrinter.printRecord(data);
			}
			
			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		}catch(IOException e) {
			throw new RuntimeException("failed to export Orders to CSV: " + e.getMessage());
		}
	}

}
