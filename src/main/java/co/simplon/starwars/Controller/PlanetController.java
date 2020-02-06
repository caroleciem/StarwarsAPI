package co.simplon.starwars.Controller;


import co.simplon.starwars.model.Planet;
import co.simplon.starwars.Repository.PlanetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/starwars")

public class PlanetController {
   /*private PlanetRepository planetRepository;

    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @GetMapping("/listPlanets")
    public ResponseEntity listPlanets() {

        List listplanets = new ArrayList<>();
        //Planet planet1 = new Planet (62L,"bisounours",25,278,0,1.0,2,200000);
        //listplanets.add(planet1);
        //listplanets.add(new Planet(63L,"Schtroumph", 25, 278, 0, 1.0, 251, 10000000));
        listplanets = planetRepository.findAll();

        return ResponseEntity.ok(listplanets);
    }


    @PostMapping("/create/planet")
    public ResponseEntity<Planet> createPlanet(@RequestBody Planet planetToCreate) {

        Planet planet = planetRepository.save(planetToCreate);

        return ResponseEntity.ok(planet);
    }

    @GetMapping("/read/planet/id/{paramDeRecherche}")
    public ResponseEntity<Planet> readPlanet(@PathVariable Long paramDeRecherche) {
        Optional<Planet> planet = planetRepository.findById(paramDeRecherche);
        if (planet.isPresent()) {
            return (ResponseEntity.ok(planet.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/planet/{id}")
    public ResponseEntity<Planet> updatePlanet(@PathVariable Long id, @RequestBody Planet planetToUpdate) {
        Optional<Planet> planet = planetRepository.findById(id);

        if (planetRepository.existsById(id)&&planetToUpdate.getId().equals(id)){
        return ResponseEntity.ok(planetRepository.save(planetToUpdate));
        }
        return ResponseEntity.notFound().build();
            //(planet.get()).setPlanetName(planetToUpdate.getPlanetName());
            //(planet.get()).setRotation_period(planetToUpdate.getRotation_period());
            //(planet.get()).setOrbital_period(planetToUpdate.getOrbital_period());
            //(planet.get()).setDiameter(planetToUpdate.getDiameter());
            //(planet.get()).setGravity(planetToUpdate.getGravity());
            //(planet.get()).setSurface_water(planetToUpdate.getSurface_water());
            //(planet.get()).setPopulation(planetToUpdate.getPopulation());

            //Planet updatePlanet = planetRepository.save(planet.get());
            //return ResponseEntity.ok(updatePlanet);
        }


    @DeleteMapping("/delete/planet/{id}")
    public ResponseEntity<Planet> deletePlanet(@PathVariable Long id) {
        Optional<Planet> planet = planetRepository.findById(id);
        planetRepository.delete(planet.get());
        //ou directement planetRepository.deleteById(id);
        return ResponseEntity.ok(planet.get());
        //return ResponseEntity.noContent().build();

    }

    @GetMapping("/read/planet/name/{paramDeRecherche}")
    public ResponseEntity<Planet> readPlanet(@PathVariable String paramDeRecherche) {
        Optional<Planet> planet = planetRepository.findByPlanetName(paramDeRecherche);
        if (planet.isPresent()) {
            return (ResponseEntity.ok(planet.get()));
        }
        return ResponseEntity.notFound().build();
    }*/
}
