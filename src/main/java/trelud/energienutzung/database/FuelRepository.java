package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Fuel;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long> {
}
