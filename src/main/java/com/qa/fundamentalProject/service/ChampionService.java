package com.qa.fundamentalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.fundamentalProject.persistence.domain.Champion;
import com.qa.fundamentalProject.persistence.repository.ChampionRepository;

@Service
public class ChampionService {

	private ChampionRepository repo;

	@Autowired
	public ChampionService(ChampionRepository repo) {
		super();
		this.repo = repo;
	}
	
	// methods
	
	public Champion create(Champion champion) {
		Champion created = this.repo.save(champion);
		
		return created;
	}
	
	public Champion readById(Long id) {
		Champion champReadFromDb = this.repo.findById(id).get();
		
		return champReadFromDb;
	}
	
	public List<Champion> readAll() {
		List<Champion> champsReadFromDb = this.repo.findAll();
		
		return champsReadFromDb;
	}
	
	public Champion updateById(Long id, Champion newChampion) {
		// gets entry to change from db
		Champion champToUpdate = this.repo.findById(id).get();   
		
		// here's the updated entry
		champToUpdate.setChampName(newChampion.getChampName());
		champToUpdate.setChampCost(newChampion.getChampCost());
		champToUpdate.setChampClass(newChampion.getChampClass());
		champToUpdate.setChampRoles(newChampion.getChampRoles());
		champToUpdate.setChampOwned(newChampion.getChampOwned());
		champToUpdate.setChampOnSale(newChampion.getChampOnSale());
		champToUpdate.setChampReleaseYear(newChampion.getChampReleaseYear());
		
		// save updated entry back to db
		return this.repo.save(champToUpdate);
	}
	
	public Champion updateByChampName(String champName, Champion newChampion) {
		// gets entry to change from db
		Champion champToUpdate = this.repo.findByChampName(champName).get();   
		
		// here's the updated entry
		champToUpdate.setChampName(newChampion.getChampName());
		champToUpdate.setChampCost(newChampion.getChampCost());
		champToUpdate.setChampClass(newChampion.getChampClass());
		champToUpdate.setChampRoles(newChampion.getChampRoles());
		champToUpdate.setChampOwned(newChampion.getChampOwned());
		champToUpdate.setChampOnSale(newChampion.getChampOnSale());
		champToUpdate.setChampReleaseYear(newChampion.getChampReleaseYear());
		
		// save updated entry back to db
		return this.repo.save(champToUpdate);
	}
	
	public boolean deleteById(Long id) {
		// tries to delete object
		this.repo.deleteById(id);
		
		// checks if that object still exists
		return !this.repo.existsById(id);
	}
	
	// custom queries under here
	
	public List<Champion> findChampionByClass(String champClass){
		List<Champion> championsInClass = this.repo.findChampionByChampClass(champClass);
		return championsInClass;
	}
	
	public List<Champion> findChampionByCost(int champCost){
		List<Champion> championsCost = this.repo.findChampionByChampCost(champCost);
		return championsCost;
	}
	
	public List<Champion> findChampionByClassAndCost(String champClass,int champCost){
		List<Champion> championsClassAndCost = this.repo.findChampionByChampClassAndChampCost(champClass,champCost);
		return championsClassAndCost;
	}
	
	public List<Champion> findChampionByRole(String champRole){
		List<Champion> championsInRole = this.repo.findChampionByChampRoles(champRole);
		return championsInRole;
	}
	
	public List<Champion> findChampionByRoleAndCost(String champRole, int champCost){
		List<Champion> championsInRoleCost = this.repo.findChampionByChampRolesAndChampCost(champRole, champCost);
		return championsInRoleCost;
	}
	
	public List<Champion> findChampionByOwned(String champOwned){
		List<Champion> championsOwned = this.repo.findChampionByChampOwned(champOwned);
		return championsOwned;
	}
	
	public List<Champion> findChampionBySale(String champOnSale){
		List<Champion> championsSale = this.repo.findChampionByChampOnSale(champOnSale);
		return championsSale;
	}
	
}
