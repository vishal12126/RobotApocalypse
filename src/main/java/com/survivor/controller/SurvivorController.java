package com.survivor.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.survivor.config.RestTemplateClient;
import com.survivor.entity.Robot;
import com.survivor.entity.Survivor;
import com.survivor.response.StatsResponse;
import com.survivor.service.SurvivorService;

@RestController
@RequestMapping("/survivor")
public class SurvivorController {
	
	@Autowired
     SurvivorService service;
	
	@Autowired
	private RestTemplateClient restTemplate;

	@Autowired
	private RestTemplateClient objectMapper;
	 static final org.slf4j.Logger log = 
			 LoggerFactory.getLogger(SurvivorController.class);
    
	@PostMapping("/addSurvivor")
	public Survivor addSurvivor(@RequestBody Survivor survivor) {
		log.info("Survivor addition method is called");
		return service.addSurvivor(survivor);
	}
	
	@PutMapping("/updateSurvivor")
	public Survivor update(@RequestBody Survivor survivor) {
		log.info("Survivor update method is called");
		return service.updateSurvivor(survivor);
	}
	
	@GetMapping("/stats")
	public StatsResponse getStats() {
		/*ResponseEntity<List<Robot>> resp = restTemplate.restTemplate().exchange("",
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<List<Robot>>(){});*/
		log.info("Survivor get stats method is called");
		String resp = restTemplate.restTemplate().getForObject(
				  "https://robotstakeover20210903110417.azurewebsites.net/robotcpu",
				  String.class);
		List<Robot> result = null;
		try {
			result = objectMapper.objectMapper().readValue(resp, new TypeReference<List<Robot>>(){});
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		//calculate number of infected and uninfected
		Predicate<Survivor> isinfect = e -> e.isInfected() == true;
		Predicate<Survivor> uninfect = e -> e.isInfected() == false;
		List<Survivor> survivorList = service.getSurvivorStats();
		long total = survivorList.size();
		log.info("total records in list :"+total);
		Long infected = survivorList.stream().filter(isinfect).count();
		Long uninfected = survivorList.stream().filter(uninfect).count();
		log.info("infected: "+ infected + " unfected: "+uninfected);
		
		//returns lists of 2 categories flying of land
		Map<String, List<Robot>> groupedByCategory = result.stream().collect(Collectors.groupingBy(Robot::getCategory));
				
		double infectedPer = ((float)infected/(float)total)*100;
		double uninfectedPer = ((float)uninfected/(float)total)*100;
		
		
		StatsResponse response= new StatsResponse();
		response.setInfected(infected);
		response.setUninfected(uninfected);
		response.setInfectedPercentage(infectedPer);
		response.setUnfectedPercentage(uninfectedPer);
		response.setRobots(groupedByCategory);

		log.info("response object: " + response.toString());
		return response;
	}
	
}
