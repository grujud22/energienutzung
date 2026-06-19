package trelud.energienutzung.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trelud.energienutzung.database.*;
import trelud.energienutzung.pojo.Fuel;
import trelud.energienutzung.pojo.Region;
import trelud.energienutzung.pojo.Sector;
import trelud.energienutzung.pojo.Year;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ConnectionService {
    private final ConnectionRepository connectionRepository;

    private final FuelRepository fuelRepository;
    private final SectorRepository sectorRepository;
    private final RegionRepository regionRepository;
    private final YearRepository yearRepository;

    public List<Map<String, Object>> getConnectionsByYearByRegionBySectorByFuelType (
            int yearNumber,
            String regionName,
            String sectorName,
            String fuelTypeName
    ) throws NoSuchObjectException {
        Region region = regionRepository.getRegionByName(regionName);
        Sector sector = sectorRepository.getSectorByName(sectorName);
        Fuel fuel = fuelRepository.getFuelByName(fuelTypeName);




        return null;
    }

}
