package com.qa.fundamentalProject.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.fundamentalProject.persistence.domain.Champion;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class ChampionControllerIntegrationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
    private final Champion TEST_SAVED_CHAMPION = new Champion(1L, "vayne", 4800, "marksman", "adc", "2013", "true", "false");
    private final Champion TEST_READ_CLASS_CHAMP = new Champion(3L, "ahri", 4800, "mage", "mid", "2014", "false", "false");
    
    @Test
    public void testCreateChampion() throws Exception {
    	final Champion newChampion = new Champion(null, "camille", 6300, "ad fighter", "top", "2015", "true", "false");
    	final Champion savedChampion = new Champion(5L, newChampion.getChampName(), newChampion.getChampCost(), newChampion.getChampClass(),
    			                       newChampion.getChampRoles(), newChampion.getChampReleaseYear(), newChampion.getChampOwned(), newChampion.getChampOnSale());
    	
    	this.mockMvc.perform(post("http://localhost:8080/champions/create").contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newChampion)))
    	.andExpect(status().isCreated()).andExpect(content().json(this.mapper.writeValueAsString(savedChampion)));
    }
    
    @Test
    public void testReadOneChamp() throws Exception {
    	this.mockMvc.perform(get("http://localhost:8080/champions/read/1")).andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_CHAMPION)));
    }
    
    
    @Test
    public void testReadAllChamps() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/readAll").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_SAVED_CHAMPION).hasSize(4);
    }
    
    @Test
    public void testUpdateChampId() throws Exception {
    	final Champion newChampion = new Champion(null, "vayne", 3150, "marksman", "adc", "2013", "true", "false");
    	String resultString = this.mockMvc.perform(put("http://localhost:8080/champions/update/1").contentType(MediaType.APPLICATION_JSON)
    						  .content(this.mapper.writeValueAsString(newChampion)))
    			              .andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();
    	
    	Champion champ = this.mapper.readValue(resultString, Champion.class);
    	assertThat(champ).isEqualTo(newChampion);
    			
    }
    
    @Test
    public void testUpdateChampName() throws Exception {
    	final Champion newChampion = new Champion(null, "vayne", 3150, "marksman", "adc", "2013", "true", "false");
    	String resultString = this.mockMvc.perform(put("http://localhost:8080/champions/update/byName/vayne").contentType(MediaType.APPLICATION_JSON)
    						  .content(this.mapper.writeValueAsString(newChampion)))
    			              .andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();
    	
    	Champion champ = this.mapper.readValue(resultString, Champion.class);
    	assertThat(champ).isEqualTo(newChampion);
    			
    }
    
    @Test
    public void testDeleteChampId() throws Exception{
    	this.mockMvc.perform(delete("http://localhost:8080/champions/delete/1")).andExpect(status().isNoContent());
    }
    
    @Test
    public void testDeleteChampByName() throws Exception{
    	this.mockMvc.perform(delete("http://localhost:8080/champions/delete/byChamp/vayne")).andExpect(status().isNoContent());
    }
    
    // custom query tests below
    
    @Test
    public void testReadChampsByClass() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/read/champByClass/mage").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_READ_CLASS_CHAMP).hasSize(2);
    }
    
    @Test
    public void testReadChampsByCost() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/read/champByCost/4800").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_SAVED_CHAMPION).hasSize(3);
    }
    
    @Test
    public void testReadChampsClassCost() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/read/champByClassAndCost/mage/4800").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_READ_CLASS_CHAMP).hasSize(2);
    }
    
    @Test
    public void testReadChampsByRole() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/read/champByRole/adc").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_SAVED_CHAMPION).hasSize(1);
    }
    
    @Test
    public void testReadChampsRoleCost() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/read/champByRoleAndCost/mid/4800").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_READ_CLASS_CHAMP).hasSize(2);
    }
    
    @Test
    public void testReadChampsOwned() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/read/champByOwned/true").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_SAVED_CHAMPION).hasSize(3);
    }
    
    @Test
    public void testReadChampsOnSale() throws Exception {
    	final String resultString = this.mockMvc.perform(get("http://localhost:8080/champions/read/champBySale/false").accept(MediaType.APPLICATION_JSON))
    								.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
    	
    	List<Object> championResults = Arrays.asList(mapper.readValue(resultString, Champion[].class));
    	assertThat(championResults).contains(this.TEST_SAVED_CHAMPION).hasSize(3);
    }
    
}
