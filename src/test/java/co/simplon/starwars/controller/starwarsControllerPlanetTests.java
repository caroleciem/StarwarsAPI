package co.simplon.starwars.controller;

import co.simplon.starwars.Repository.ClimateRepository;
import co.simplon.starwars.Repository.PlanetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class starwarsControllerPlanetTests {

    @Autowired
    MockMvc mockMvc;
    @Mock
    PlanetRepository planetRepo;

    @Test
    public void getAllPlanet() throws Exception {
        when(this.planetRepo.findAll()).thenReturn(new ArrayList<>());


        this.mockMvc.perform(get("/api/starwars/listPlanets")).andExpect(status().isOk());


    }
}
