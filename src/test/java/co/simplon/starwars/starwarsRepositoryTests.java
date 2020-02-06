package co.simplon.starwars;

import co.simplon.starwars.Repository.ClimateRepository;
import co.simplon.starwars.model.Climate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class starwarsRepositoryTests {
    @Autowired
    private ClimateRepository climateRepo;

    @Autowired
    private TestEntityManager testEntityManager;

    /*@Test
    public void findClimateById() throws Exception {
        Climate savedClimate= testEntityManager.persistFlushFind(new Climate(15L,"beautiful"));
        Optional<Climate> beautiful = this.climateRepo.findById(15L);
        assertThat(beautiful.getClimateName()).isEqualTo(savedClimate.getClimateName());

    }*/
}
