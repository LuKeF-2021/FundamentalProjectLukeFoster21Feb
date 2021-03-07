package com.qa.fundamentalProject.service;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.qa.fundamentalProject.persistence.domain.Champion;
import com.qa.fundamentalProject.persistence.repository.ChampionRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ChampionServiceUnitTests {
	
	@Autowired
	private ChampionService service;
	
	@MockBean
	private ChampionRepository repo;
	
	@Test
	void testCreateChampion() {
		// given
		final Champion TEST_CHAMPION = new Champion(null, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
		final Champion TEST_SAVED_CHAMPION = new Champion(1L, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
		// when
		Mockito.when(this.repo.save(TEST_CHAMPION)).thenReturn(TEST_SAVED_CHAMPION);
		// then
		Assertions.assertThat(this.service.create(TEST_CHAMPION)).isEqualTo(TEST_SAVED_CHAMPION);
        // verify mock repo accessed once
		Mockito.verify(this.repo, Mockito.times(1)).save(TEST_CHAMPION);
		
	}
	
	@Test
	void testReadChampionById() {
		// given
		Long id = 1L;
		final Champion TEST_CHAMPION = new Champion(id, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
		// when
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(TEST_CHAMPION));
		// then
		Assertions.assertThat(this.service.readById(id)).isEqualTo(TEST_CHAMPION);
        // verify mock repo accessed once
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		
	}
	
	@Test
	void testReadAllChampions() {
		// given
		Long id = 1L;
		final Champion TEST_CHAMPION = new Champion(id, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
		TEST_CHAMPION.setChampID(id);
		List<Champion> champions = List.of(TEST_CHAMPION);
		// when
		Mockito.when(this.repo.findAll()).thenReturn(champions);
		// then
		Assertions.assertThat(this.service.readAll()).isEqualTo(champions);
        // verify mock repo accessed once
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	
	@Test
	void testUpdateChampionId() {
		// given
		Long id = 1L;
		Champion newChampion = new Champion(null, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
		Champion existingChampion = new Champion(id, "vayne", 3150, "marksman", "adc", "2013", "true", "true");
		Champion updatedChampion = new Champion(id, newChampion.getChampName(),newChampion.getChampCost(),
				 newChampion.getChampClass(),newChampion.getChampRoles(),newChampion.getChampReleaseYear(),
				 newChampion.getChampOwned(), newChampion.getChampOnSale());
		// when
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existingChampion));
        Mockito.when(this.repo.save(updatedChampion)).thenReturn(updatedChampion);
        // then
        Assertions.assertThat(this.service.updateById(id, newChampion)).isEqualTo(updatedChampion);
        // verify
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updatedChampion);
	}
	
	@Test
	void testUpdateChampionName() {
		// given
		Long id = 1L;
		String championName = "vayne";
		Champion newChampion = new Champion(null, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
		Champion existingChampion = new Champion(id, "vayne", 3150, "marksman", "adc", "2013", "true", "true");
		Champion updatedChampion = new Champion(id, newChampion.getChampName(),newChampion.getChampCost(),
				 newChampion.getChampClass(),newChampion.getChampRoles(),newChampion.getChampReleaseYear(),
				 newChampion.getChampOwned(), newChampion.getChampOnSale());
		// when
		Mockito.when(this.repo.findByChampName(championName)).thenReturn(Optional.of(existingChampion));
        Mockito.when(this.repo.save(updatedChampion)).thenReturn(updatedChampion);
        // then
        Assertions.assertThat(this.service.updateByChampName(championName, newChampion)).isEqualTo(updatedChampion);
        // verify
        Mockito.verify(this.repo, Mockito.times(1)).findByChampName(championName);
        Mockito.verify(this.repo, Mockito.times(1)).save(updatedChampion);
	}
	
	   @Test
	    void testDeleteChampionId() {

	        // given
	        Long id = 1L;
	        // when
	        Mockito.when(this.repo.existsById(id)).thenReturn(false);
	        // then
	        Assertions.assertThat(this.service.deleteById(id)).isTrue();
	        // verify
	        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	    }
	
	   @Test
	    void testDeleteChampionName() {

	        // given
	        String championName = "vayne";
	        final Champion TEST_CHAMPION = new Champion(1L, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
	        // when
	        Mockito.when(this.repo.findByChampName(championName)).thenReturn(Optional.of(TEST_CHAMPION));
	        // then
	        Assertions.assertThat(this.service.ChampRemove(championName)).isFalse();
	        // verify
	        Mockito.verify(this.repo, Mockito.times(1)).findByChampName(championName);

	    }
	   
	   // custom query unit tests below
	   
//	   @Test
//		void testReadChampionsClass() {
//			// given
//			Long id = 1L;
//			String championClass = "marksman";
//			final Champion TEST_CHAMPION = new Champion(id, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
//			TEST_CHAMPION.setChampClass(championClass);
//			List<Champion> champions = List.of(TEST_CHAMPION);
//			// when
//			Mockito.when(this.repo.findChampionByChampClass(championClass)).thenReturn(champions);
//			// then
//			Assertions.assertThat(this.service.findChampionByClass(championClass)).isEqualTo(champions);
//	        // verify mock repo accessed once
//			Mockito.verify(this.repo, Mockito.times(1)).findChampionByChampClass(championClass);
//			
//		}
	   
}
