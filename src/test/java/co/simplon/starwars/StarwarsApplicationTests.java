package co.simplon.starwars;

import co.simplon.starwars.model.Climate;
import co.simplon.starwars.model.Planet;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StarwarsApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    //get Climate list
    @Test
    public void getClimat() {
        // When retrieving cities from /api/starwars/listclimats
        List<?> climat = this.restTemplate.getForObject("/api/starwars/listclimats", List.class);
        // Then a non null list should be returned
        assertThat(climat).isNotNull();
    }
    //get  Planet list
    @Test
    public void getPlanet() {
        // When retrieving cities from /api/starwars/listPlanets
        ResponseEntity<List> responseEntity = this.restTemplate.exchange("/api/starwars/listPlanets", HttpMethod.GET,null, List.class);
        // Then a non null list should be returned
        List<?>planet =responseEntity.getBody();
        assertThat(planet).isNotNull();
    }
    //get existing Climate
    @Test
    public void getClimatById() {
        // When retrieving an existing city by its name
        ResponseEntity<Climate> responseEntity = this.restTemplate.getForEntity("/api/starwars/read/climate/id/{paramDeRecherche}", Climate.class, "1");
        Climate climateTemp = responseEntity.getBody();

        // Then OK status code should be sent back and
        // the city should be returned and should be filled with its attributes
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(climateTemp.getClimateName()).isEqualTo("temperate");
        assertThat(climateTemp.getId()).isEqualTo("1");
    }
    //get non existing Climate
    @Test
    public void getNonExistinsById() {
        // When retrieving an existing city by its name
        ResponseEntity<Climate> responseEntity = this.restTemplate.getForEntity("/api/starwars/read/climate/id/{paramDeRecherche}", Climate.class, "3000");
        Climate climateTemp = responseEntity.getBody();

        // Then OK status code should be sent back and
        // the city should be returned and should be filled with its attributes
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);


    }
    @Test
    public void getNonExistingById() {
        // When retrieving an existing city by its name
        ResponseEntity<Climate> responseEntity = this.restTemplate.exchange("/api/starwars/read/climate/id/{paramDeRecherche}", HttpMethod.GET, null,Climate.class, "3000");

        // Then OK status code should be sent back and
        // the city should be returned and should be filled with its attributes
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);


    }
    //create Climate
    @Test
    public void addClimate() {
        // Given a new valid city
        String climateName = "hot";
        Climate newClimate = new Climate(climateName);

        HttpEntity<Climate> hotEntity = new HttpEntity<Climate>(newClimate,null);

        // When posting this city to /api/city
        ResponseEntity<Climate> responseEntity = this.restTemplate.postForEntity("/api/starwars/create/climat", hotEntity, Climate.class);
        Climate createdHot = responseEntity.getBody();

        // Then OK status code should be sent back and
        // the created city should be returned and should be filled with its attributes
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(createdHot.getId()).isPositive();
        assertThat(createdHot.getClimateName()).isEqualTo("hot");

    }

    //update existing Climate mais pas fait dans le Climate
    @Test
    public void updateClimatById() {
        // When retrieving an existing climate by its name
        String newName = "tropical";
        Climate existingClimate = new Climate(2L,newName);
        HttpEntity<Planet> climatHttpEntity = new HttpEntity(existingClimate, null);
        ResponseEntity<Climate> responseEntity = this.restTemplate.exchange("/api/starwars/update/climate/{id}", HttpMethod.PUT,climatHttpEntity,Climate.class, "2");
        Climate climateTemp = responseEntity.getBody();

        // Then OK status code should be sent back and
        // the city should be returned and should be filled with its attributes
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(climateTemp.getClimateName()).isEqualTo(newName);
        assertThat(climateTemp.getId()).isEqualTo(2L);
    }

   @Test
    public void updatePlanetById() {
        // When retrieving an existing planet by its name
        String newPlanetName = "test";
        Planet existingPlanet = new Planet(1l,newPlanetName);
        HttpEntity<Planet> planetHttpEntity = new HttpEntity(existingPlanet, null);
        ResponseEntity<Planet> responseEntity = this.restTemplate.exchange("/api/starwars/update/planet/{id}", HttpMethod.PUT,planetHttpEntity,Planet.class, "1");
        Planet planetTemp = responseEntity.getBody();

        // Then OK status code should be sent back and
        // the city should be returned and should be filled with its attributes
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(planetTemp.getPlanetName()).isEqualTo(newPlanetName);
        assertThat(planetTemp.getId()).isEqualTo(1L);
    }


}
