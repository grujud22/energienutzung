package trelud.energienutzung.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import trelud.energienutzung.database.ConnectionRepository;
import trelud.energienutzung.pojo.*;
import trelud.energienutzung.service.ConnectionService;
import trelud.energienutzung.service.DtoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConnectionController.class)
class ConnectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ConnectionService connectionService;

    @Test
    void get_shouldReturnOneConnection() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Connection> expectedConnections = new ArrayList<>();

        Connection expectedConnection = new Connection();

        Sector expectedSector = new Sector();
        expectedSector.setSectorName("Agriculture");
        expectedConnection.setSector(expectedSector);

        Region expectedRegion = new Region();
        expectedRegion.setRegionName("Styria");
        expectedConnection.setRegion(expectedRegion);

        trelud.energienutzung.pojo.Year expectedYear = new Year();
        expectedYear.setYear(2020);
        expectedConnection.setYear(expectedYear);

        Fuel expectedFuel = new Fuel();
        expectedFuel.setFuelName("Hard coal");
        expectedConnection.setFuel(expectedFuel);

        expectedConnections.add(expectedConnection);

        List<Map<String, Object>> expectedList =
                DtoService.convertList(
                        expectedConnections
                );

        String expectedJson = objectMapper.writeValueAsString(expectedList);

        when(
                connectionService
                        .getConnectionsByYearByRegionBySectorByFuelType(
                                2020,
                                "Styria",
                                "Agriculture",
                                "Hard coal"))
                .thenReturn(expectedList);

        mockMvc.perform(
                get(
                        "http://localhost:8080/energy/connection?year=2020&region=Styria&sector=Agriculture&fuelType=Hard coal"
                ))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}