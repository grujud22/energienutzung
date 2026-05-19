package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
