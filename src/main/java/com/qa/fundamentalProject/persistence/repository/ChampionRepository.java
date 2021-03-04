package com.qa.fundamentalProject.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.fundamentalProject.persistence.domain.Champion;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {

	// SELECT * from champions where champClass = '';
    List<Champion> findChampionByChampClass(String champClass);

	// SELECT * from champions where champCost = x;
    List<Champion> findChampionByChampCost(int champCost);

	// SELECT * from champions where champClass = '' and champCost = x;
    List<Champion> findChampionByChampClassAndChampCost(String champClass, int champCost);

	Optional<Champion> findByChampName(String champName);

	// SELECT * from champions where champRole = '' ;
    List<Champion> findChampionByChampRoles(String champRole);

	// SELECT * from champions where champRole = '' and champRole = '';
//  List<Champion> findChampionByChampRole(String champRole, String secondChampRole);

	// SELECT * from champions where champRole = '' and champCost = x;
	List<Champion> findChampionByChampRolesAndChampCost(String champRole, int champCost);

	// SELECT * from champions where champOwned = '' ;
	List<Champion> findChampionByChampOwned(String champOwned);

	// SELECT * from champions where champOnSale = '' ;
	List<Champion> findChampionByChampOnSale(String champOnSale);

}
