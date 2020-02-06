package co.simplon.starwars.controller;

import co.simplon.starwars.Repository.ClimateRepository;
import co.simplon.starwars.Repository.PlanetRepository;
import co.simplon.starwars.model.Climate;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javafx.beans.binding.Bindings.when;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class starwarsControllerClimateTests {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ClimateRepository climateRepo;
    PlanetRepository PlanetRepo;


    @Test
    public void getAllClimate() throws Exception {
        when(this.climateRepo.findAll()).thenReturn(new ArrayList<>());


        mockMvc.perform(get("/api/starwars/listclimats")).andExpect(status().isOk());


    }
    @Test
    public void getClimateById() throws Exception {
        when(this.climateRepo.findById(anyLong())).thenReturn(java.util.Optional.of(new Climate(1L, "temperate")));


        this.mockMvc.perform(get("/api/starwars/read/climate/id/1")).andExpect(status().isOk());


    }
    @Test
    public void getNonExistingClimateById() throws Exception {
        when(this.climateRepo.findById(anyLong())).thenReturn(Optional.empty());


        this.mockMvc.perform(get("/api/starwars/read/climate/id/2000")).andExpect(status().isNotFound());


    }
    @Test
    public void createClimate() throws Exception {
        when(this.climateRepo.save(any())).thenReturn(new Climate(1, "temperate"));


        this.mockMvc.perform(post("/api/starwars/create/climat")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"temperate\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("temperate")
                .andExpect(jsonPath("id").value(1)));



    }


}
