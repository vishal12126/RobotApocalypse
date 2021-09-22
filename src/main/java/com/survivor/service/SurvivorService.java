package com.survivor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survivor.entity.Survivor;
import com.survivor.repository.SurvivorRepository;

@Service
public class SurvivorService {

	@Autowired
	private SurvivorRepository repository;
	
	public Survivor addSurvivor(Survivor s) {
		return repository.save(s);
	}	
	
	public Survivor updateSurvivor(Survivor s) {
		return repository.save(s);
	}
	
	public List<Survivor> getSurvivorStats() {
		return repository.findAll();
	}
	
}
