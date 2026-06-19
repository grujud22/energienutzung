package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Region;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    @Query("SELECT r FROM Region r WHERE Upper(r.regionName) = Upper(:regionName)")
    Optional<Region> getRegionByName(
            @Param("regionName") String regionName
    );
}