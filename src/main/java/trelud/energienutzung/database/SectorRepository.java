package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
}
