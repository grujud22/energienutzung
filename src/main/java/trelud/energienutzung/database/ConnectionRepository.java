package trelud.energienutzung.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import trelud.energienutzung.pojo.Connection;

import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    @Query("SELECT c FROM Connection c WHERE "
            + "(c.year.year = :yearNumber OR :yearNumber = -1) "
            + "AND (Upper(c.region.regionName) = Upper(:regionName) OR :regionName = '*') "
            + "AND (Upper(c.sector.sectorName) = Upper(:sectorName) OR :sectorName = '*') "
            + "AND (Upper(c.fuel.fuelName) = Upper(:fuelTypeName) OR :fuelTypeName = '*')")
    List<Connection> getConnectionsByYearByRegionBySectorByFuelType(
            @Param("yearNumber") int yearNumber,
            @Param("regionName") String regionName,
            @Param("sectorName") String sectorName,
            @Param("fuelTypeName") String fuelTypeName
    );
}
