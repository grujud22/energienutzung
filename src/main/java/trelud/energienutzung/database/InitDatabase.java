package trelud.energienutzung.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import trelud.energienutzung.pojo.Sector;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDatabase implements ApplicationRunner {
    public final SectorRepository sectorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            InputStream is = this.getClass().getResourceAsStream("/energy.json");

            ObjectMapper objectMapper = new ObjectMapper();

            List<Sector> sectors = objectMapper
                    .readerForListOf(Sector.class)
                    .readValue(is);

            sectors.forEach(s -> {
                s.getYears().forEach(y -> {
                    y.getFuels().forEach(f -> {
                        f.setYear(y);
                    });
                    y.setSector(s);
                });
            });


            sectorRepository.saveAll(sectors);
        }catch (IOException ioex){
            log.warn("File problem");
            log.debug("File problem " + ioex.getMessage());
            throw new RuntimeException(ioex);
        }
    }
}
