package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import trelud.energienutzung.pojo.Year;

import java.util.Optional;

public interface YearRepository extends JpaRepository<Year, Long> {
    Optional<Year> findByYear(int year);
}
