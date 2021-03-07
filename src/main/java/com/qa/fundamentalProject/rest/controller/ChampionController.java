package com.qa.fundamentalProject.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.fundamentalProject.persistence.domain.Champion;
import com.qa.fundamentalProject.service.ChampionService;

@CrossOrigin
@RestController
@RequestMapping("/champions")
public class ChampionController {

	// passes things to the service
	private ChampionService service;

	@Autowired
	public ChampionController(ChampionService service) { // constructor
		super();
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<Champion> create(@RequestBody Champion champion) {
		Champion createdObject = this.service.create(champion);
		return new ResponseEntity<>(createdObject, HttpStatus.CREATED);
	}

	// readById
	@GetMapping("/read/champById/{id}")
	public ResponseEntity<Champion> readById(@PathVariable Long id) {
		Champion returnedObject = this.service.readById(id);
		return ResponseEntity.ok(returnedObject);
	}

	// readAll
	@GetMapping("/readAll")
	public ResponseEntity<List<Champion>> readAll() {

		return ResponseEntity.ok(this.service.readAll());
	}

	// updateById
	@PutMapping("/update/{id}")
	public ResponseEntity<Champion> updateById(@PathVariable Long id, @RequestBody Champion champion) {
		Champion updatedObject = this.service.updateById(id, champion);
		return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
	}

	// updateByChampName
	@PutMapping("/update/byName/{champName}")
	public ResponseEntity<Champion> updateByChampName(@PathVariable String champName, @RequestBody Champion champion) {
		Champion updatedObject = this.service.updateByChampName(champName, champion);
		return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
	}

	// deleteById
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Champion> deleteById(@PathVariable Long id) {
		if (this.service.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	// deleteByName
	@DeleteMapping("/delete/byChamp/{champName}")
	public ResponseEntity<Champion> deleteByChampName(@PathVariable String champName) {
		if (this.service.ChampRemove(champName)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	// custom queries below

	// find champs by class
	@GetMapping("/read/champByClass/{champClass}")
	public ResponseEntity<List<Champion>> findByClass(@PathVariable String champClass) {
		List<Champion> champsInClass = this.service.findChampionByClass(champClass);
		return ResponseEntity.ok(champsInClass);
	}

	// find champs by cost
	@GetMapping("/read/champByCost/{champCost}")
	public ResponseEntity<List<Champion>> findByCost(@PathVariable int champCost) {
		List<Champion> champsCostMatch = this.service.findChampionByCost(champCost);
		return ResponseEntity.ok(champsCostMatch);
	}

	// find champs by class and cost
	@GetMapping("/read/champByClassAndCost/{champClass}/{champCost}")
	public ResponseEntity<List<Champion>> findByClassAndCost(@PathVariable String champClass,
			@PathVariable int champCost) {
		List<Champion> champsClassCost = this.service.findChampionByClassAndCost(champClass, champCost);
		return ResponseEntity.ok(champsClassCost);
	}

	// find champs by role
	@GetMapping("/read/champByRole/{champRole}")
	public ResponseEntity<List<Champion>> findByRole(@PathVariable String champRole) {
		List<Champion> champsInRole = this.service.findChampionByRole(champRole);
		return ResponseEntity.ok(champsInRole);
	}

	// find champs by role and cost
	@GetMapping("/read/champByRoleAndCost/{champRole}/{champCost}")
	public ResponseEntity<List<Champion>> findByRoleAndCost(@PathVariable String champRole,
			@PathVariable int champCost) {
		List<Champion> champsInRoleCost = this.service.findChampionByRoleAndCost(champRole, champCost);
		return ResponseEntity.ok(champsInRoleCost);
	}

	// find champs by Owned status
	@GetMapping("/read/champByOwned/{champOwned}")
	public ResponseEntity<List<Champion>> findByOwned(@PathVariable String champOwned) {
		List<Champion> champsOwned = this.service.findChampionByOwned(champOwned);
		return ResponseEntity.ok(champsOwned);
	}

	// find champs by on sale
	@GetMapping("/read/champBySale/{champOnSale}")
	public ResponseEntity<List<Champion>> findBySale(@PathVariable String champOnSale) {
		List<Champion> champsSale = this.service.findChampionBySale(champOnSale);
		return ResponseEntity.ok(champsSale);
	}

}
