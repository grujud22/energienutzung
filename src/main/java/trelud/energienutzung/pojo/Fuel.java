package trelud.energienutzung.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fuel")
@Data
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    @Column(name = "space_and_water_heating_tj")
    private Double spaceAndWaterHeating;

    @Column(name = "process_heat_below_200c_tj")
    private Double processHeatBelow200c;

    @Column(name = "process_heat_above_200c_tj")
    private Double processHeatAbove200c;

    @Column(name = "stationary_engines_tj")
    private Double stationaryEngines;

    @Column(name = "traction_tj")
    private Double traction;

    @Column(name = "lighting_and_computing_tj")
    private Double lightingAndComputing;

    @Column(name = "electrochemical_purposes_tj")
    private Double electrochemicalPurposes;
}
