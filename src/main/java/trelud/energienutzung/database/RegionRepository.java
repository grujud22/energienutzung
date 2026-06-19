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
//    @Query("SELECT r FROM Region r WHERE r.year.year = 2024")
//    List<Region> findAllByLatest();
//    @Query("SELECT r FROM Region r WHERE r.year.year = :yearNum")
//    List<Region> findAllByYear(@Param("yearNum") int year);

    @Query("SELECT r FROM Region r WHERE r.regionName = :regionName")
    Optional<Region> getRegionByName(
            @Param("regionName") String regionName
    );
}