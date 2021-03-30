package com.generator.csv.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generator.csv.ms.helper.CSVOrdersHelper;
import com.generator.csv.ms.service.CSVService;

@Controller
@RequestMapping("/")
public class CSVController {

	private static Logger log = LoggerFactory.getLogger(CSVController.class);
	@Autowired
	CSVService csvService;
	
	@GetMapping
	public ResponseEntity<Resource> getFile(){
		log.info("GET getFile with args []");
		InputStreamResource is = new InputStreamResource(csvService.download());
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "Attachment; filename="+CSVOrdersHelper.FILENAME)
				.contentType(MediaType.parseMediaType("application/csv"))
				.body(is);
	}
}
