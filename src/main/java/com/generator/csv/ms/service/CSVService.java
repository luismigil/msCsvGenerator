package com.generator.csv.ms.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generator.csv.ms.controller.CSVController;
import com.generator.csv.ms.helper.CSVOrdersHelper;
import com.generator.csv.ms.model.Orders;
import com.generator.csv.ms.repository.OrdersRepository;

@Service
public class CSVService {

	private static Logger log = LoggerFactory.getLogger(CSVService.class);
	@Autowired
	OrdersRepository ordersRepository;
	
	public ByteArrayInputStream download() {
		log.info("CALLING download() with args[]");
		
		List<Orders> orders = ordersRepository.findAllByOrderByOrderIdAsc();
		
		ByteArrayInputStream in = CSVOrdersHelper.ordersToCsv(orders);
		log.info("RESPONSE from download() [{}]", in);
		return in;
	}
}
