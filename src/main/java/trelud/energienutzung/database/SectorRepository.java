package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Sector;

import java.util.Optional;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    @Query("SELECT s FROM Sector s WHERE Upper(s.sectorName) = Upper(:sectorName)")
    Optional<Sector> getSectorByName(
            @Param("sectorName") String sectorName
    );
}
