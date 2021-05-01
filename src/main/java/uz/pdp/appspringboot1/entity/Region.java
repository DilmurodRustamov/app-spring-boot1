package uz.pdp.appspringboot1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String nameUz;

    @Column(unique = true,nullable = false)
    private String nameRu;

    @Column(unique = true,nullable = false)
    private String nameEn;

    @ManyToOne
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<District> districts;
}
