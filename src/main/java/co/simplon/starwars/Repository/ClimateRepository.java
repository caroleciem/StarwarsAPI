package co.simplon.starwars.Repository;

import co.simplon.starwars.model.Climate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimateRepository extends JpaRepository<Climate,Long> {
}
