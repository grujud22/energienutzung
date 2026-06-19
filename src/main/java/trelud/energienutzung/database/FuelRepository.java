package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Fuel;

import java.util.List;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long> {
    @Query("SELECT f FROM Fuel f WHERE Upper(f.fuelName) = Upper(:fuelName)")
    List<Fuel> getFuelByName(
            @Param("fuelName") String fuelName
    );
}
