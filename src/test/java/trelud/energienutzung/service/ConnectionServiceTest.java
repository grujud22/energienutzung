package trelud.energienutzung.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import trelud.energienutzung.database.*;
import trelud.energienutzung.pojo.Fuel;
import trelud.energienutzung.pojo.Region;
import trelud.energienutzung.pojo.Sector;
import trelud.energienutzung.pojo.Year;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConnectionServiceTest {
    @Mock
    private ConnectionRepository connectionRepository;
    @Mock
    private FuelRepository fuelRepository;
    @Mock
    private SectorRepository sectorRepository;
    @Mock
    private RegionRepository regionRepository;
    @Mock
    private YearRepository yearRepository;

    @InjectMocks
    private ConnectionService connectionService;

    @Test
    void getConnections_ShouldReturnConvertedList_WhenAllExist() {
        int yearNum = 2020;
        String regionName = "Styria";
        String sectorName = "Agriculture";
        String fuelName = "Hard coal";

        when(regionRepository.getRegionByName(regionName)).thenReturn(Optional.of(new Region()));
        when(sectorRepository.getSectorByName(sectorName)).thenReturn(Optional.of(new Sector()));
        when(fuelRepository.getFuelByName(fuelName)).thenReturn(List.of(new Fuel()));
        when(yearRepository.findByYear(yearNum)).thenReturn(Optional.of(new Year()));

        when(connectionRepository
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName))
                .thenReturn(List.of());


        List<Map<String, Object>> result = connectionService
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void getConnections_ShouldReturnConvertedList_WhenAllWildcards() {
        int yearNum = -1;
        String regionName = "*";
        String sectorName = "*";
        String fuelName = "*";

        when(regionRepository.getRegionByName(regionName)).thenReturn(Optional.empty());
        when(sectorRepository.getSectorByName(sectorName)).thenReturn(Optional.empty());
        when(fuelRepository.getFuelByName(fuelName)).thenReturn(List.of());
        when(yearRepository.findByYear(yearNum)).thenReturn(Optional.empty());

        when(connectionRepository
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName))
                .thenReturn(List.of());


        List<Map<String, Object>> result = connectionService
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void getConnections_ShouldThrowError_WhenWrongYear(){
        int yearNum = 20;
        String regionName = "*";
        String sectorName = "*";
        String fuelName = "*";

        when(regionRepository.getRegionByName(regionName)).thenReturn(Optional.empty());
        when(sectorRepository.getSectorByName(sectorName)).thenReturn(Optional.empty());
        when(fuelRepository.getFuelByName(fuelName)).thenReturn(List.of());
        when(yearRepository.findByYear(yearNum)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> connectionService
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName));
    }

    @Test
    void getConnections_ShouldThrowError_WhenWrongRegion(){
        int yearNum = -1;
        String regionName = "Affe";
        String sectorName = "*";
        String fuelName = "*";

        when(regionRepository.getRegionByName(regionName)).thenReturn(Optional.empty());
        when(sectorRepository.getSectorByName(sectorName)).thenReturn(Optional.empty());
        when(fuelRepository.getFuelByName(fuelName)).thenReturn(List.of());
        when(yearRepository.findByYear(yearNum)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> connectionService
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName));
    }

    @Test
    void getConnections_ShouldThrowError_WhenWrongSector(){
        int yearNum = 20;
        String regionName = "*";
        String sectorName = "Affe";
        String fuelName = "*";

        when(regionRepository.getRegionByName(regionName)).thenReturn(Optional.empty());
        when(sectorRepository.getSectorByName(sectorName)).thenReturn(Optional.empty());
        when(fuelRepository.getFuelByName(fuelName)).thenReturn(List.of());
        when(yearRepository.findByYear(yearNum)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> connectionService
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName));
    }

    @Test
    void getConnections_ShouldThrowError_WhenWrongFuel(){
        int yearNum = 20;
        String regionName = "*";
        String sectorName = "*";
        String fuelName = "Affe";

        when(regionRepository.getRegionByName(regionName)).thenReturn(Optional.empty());
        when(sectorRepository.getSectorByName(sectorName)).thenReturn(Optional.empty());
        when(fuelRepository.getFuelByName(fuelName)).thenReturn(List.of());
        when(yearRepository.findByYear(yearNum)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> connectionService
                .getConnectionsByYearByRegionBySectorByFuelType(yearNum, regionName, sectorName, fuelName));
    }
}