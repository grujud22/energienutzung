package trelud.energienutzung.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trelud.energienutzung.database.RegionRepository;
import trelud.energienutzung.pojo.Region;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;

//    public List<Map<String, Object>> getRegion(){
//        return DtoService.convertList(regionRepository.findAllByLatest());
//    }
//
//    public List<Map<String, Object>> getRegionByYear(int year) throws NoSuchObjectException {
//        List<Region> regions = regionRepository.findAllByYear(year);
//        if(regions == null || regions.isEmpty())
//            throw new NoSuchObjectException("No Regions for year " + year + " found");
//        return DtoService.convertList(regions);
//    }
}
