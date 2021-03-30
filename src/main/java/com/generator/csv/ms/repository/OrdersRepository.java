package com.generator.csv.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generator.csv.ms.model.Orders;


public interface OrdersRepository extends JpaRepository<Orders, Long>{
	
	public List<Orders> findAllByOrderByOrderIdAsc();

}
