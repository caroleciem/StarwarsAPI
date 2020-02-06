package co.simplon.starwars.Controller;

import co.simplon.starwars.Repository.ClimateRepository;
import co.simplon.starwars.model.Climate;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/starwars")
public class ClimateController {
    private ClimateRepository climateRepository;

    public ClimateController(ClimateRepository climateRepository) {
        this.climateRepository = climateRepository;
    }

    @GetMapping("/listclimats")
    public ResponseEntity listsClimats(){
        List <Climate> listClimats = new ArrayList<>();
        listClimats =climateRepository.findAll();
        return  ResponseEntity.ok(listClimats);
    }
    @PostMapping("/create/climat")
    public ResponseEntity<Climate> createPlanet(@RequestBody Climate climateToCreate) {

        Climate climate = climateRepository.save(climateToCreate);

        return ResponseEntity.ok(climate);
    }
    @GetMapping("/read/climate/id/{paramDeRecherche}")
    public ResponseEntity<Climate> readPlanet(@PathVariable Long paramDeRecherche) {
        Optional<Climate> climat = climateRepository.findById(paramDeRecherche);
        if (climat.isPresent()) {
            return (ResponseEntity.ok(climat.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/update/climate/{id}")
    public ResponseEntity<Climate> updatePlanet( @PathVariable Long id , @RequestBody Climate climateToUpdate) {
        Optional<Climate>  climat = climateRepository.findById(id);
        if (climateRepository.existsById(id)&&climateToUpdate.getId().equals(id)) {
            return (ResponseEntity.ok(climateRepository.save(climateToUpdate)));
        }
        return ResponseEntity.notFound().build();
    }





}
