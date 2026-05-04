package trelud.energienutzung.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fuel {
    @Id
    Long fuel_id;

    @ManyToOne
    @JoinColumn(name = "year_id")
    Year year;

    String fuel;

    @JsonProperty("Space and water heating")
    Double SpaceAndWaterHeating;

    @JsonProperty("Process heat <200 °C")
    Double processHeatUnder200;

    @JsonProperty("Process heat >200 °C")
    Double processHeatOver200;

    @JsonProperty("Stationary engines")
    Double stationaryEngines;

    @JsonProperty("Traction")
    Double traction;

    @JsonProperty("Lighting and computing")
    Double lightingAndComputing;

    @JsonProperty("Electrochemical purposes")
    Double electrochemicalPurposes;
}
