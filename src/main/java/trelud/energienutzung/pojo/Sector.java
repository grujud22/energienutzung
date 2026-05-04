package trelud.energienutzung.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sector {
    @Id
    Long sector_id;

    String sector;

    @OneToMany(
            mappedBy = "sector",
            cascade = CascadeType.ALL
    )
    List<Year> years;
}
