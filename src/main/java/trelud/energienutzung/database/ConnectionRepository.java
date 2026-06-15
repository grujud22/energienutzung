package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
}
