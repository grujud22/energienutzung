package trelud.energienutzung.pojo;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sector")
@Data
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sector_id;

    @JsonAlias({"sector_name"})
    private String sectorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    @ToString.Exclude
    private Region region;

    @OneToMany(mappedBy = "sector",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Fuel> fuels = new ArrayList<>();
}
