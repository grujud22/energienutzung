package trelud.energienutzung.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Year {
    @Id
    Long year_id;

    Integer year;

    @OneToMany(
            mappedBy = "year",
            cascade = CascadeType.ALL
    )
    List<Fuel> fuels;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    Sector sector;
}
