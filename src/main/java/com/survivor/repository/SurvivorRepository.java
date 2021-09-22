package com.survivor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survivor.entity.Survivor;

public interface SurvivorRepository extends JpaRepository<Survivor, Integer> {}
